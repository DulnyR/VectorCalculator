import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class VectorCalculator {
	static List<Double> crossProduct(List<Double> vectorArrayOne, List<Double> vectorArrayTwo) {
		double CPXOne = ((vectorArrayOne.get(1) * vectorArrayTwo.get(2)) - (vectorArrayOne.get(2) * vectorArrayTwo.get(1)));
		double CPXTwo = ((vectorArrayOne.get(2) * vectorArrayTwo.get(0)) - (vectorArrayOne.get(0) * vectorArrayTwo.get(2)));
		double CPXThree = ((vectorArrayOne.get(0) * vectorArrayTwo.get(1)) - (vectorArrayOne.get(1) * vectorArrayTwo.get(0)));
		List<Double> crossProduct = Arrays.asList(CPXOne, CPXTwo, CPXThree);
		return crossProduct;
	}
	
	static Double dotProduct(List<Double> vectorArrayOne, List<Double> vectorArrayTwo){
		int dimension = vectorArrayOne.size();
		double firstMul = (vectorArrayOne.get(0) * vectorArrayTwo.get(0));
		double secondMul = (vectorArrayOne.get(1) * vectorArrayTwo.get(1));
		double dotProductTwoD = firstMul  + secondMul;
		if(dimension == 2) {
			return dotProductTwoD;
		}
		if(dimension == 3) {
			double thirdMul = (vectorArrayOne.get(2) * vectorArrayTwo.get(2));
			double dotProductThreeD = dotProductTwoD + thirdMul;
			return dotProductThreeD;
		}
		else {
			return 100.0;
		}
	}
	
	static Double magnitude(List<Double> vectorArray) {
		int counter = 0;
		double totalSquared = 0;
		int dimension = vectorArray.size();
		while (counter < dimension) {
			double power = Math.pow(vectorArray.get(counter), 2);
			totalSquared = totalSquared + power;
			counter = counter + 1;
			}
		double total = Math.sqrt(totalSquared);
		return total;
		}
	
	static List<Double> scalarProduct(double scalar, List<Double> vectorArray){
		int counter = 0;
		int dimension = vectorArray.size();
		ArrayList<Double> scalarProduct = new ArrayList<Double>();
		while (counter < dimension)	{
			double multipliedVector = scalar * vectorArray.get(counter);
			scalarProduct.add(multipliedVector);
			counter = counter + 1;
		}
		return scalarProduct;
	}
	
	static List<Double> unitVector(List<Double> vectorArray, double magnitude){
		int counter = 0;
		int dimension = vectorArray.size();
		ArrayList<Double> unitVector = new ArrayList<Double>();
		while (counter < dimension) {
			double dividedVector = vectorArray.get(counter) / magnitude;
			unitVector.add(dividedVector);
			counter = counter + 1;
		}
		return unitVector;
	}
	
	static Double angleBetweenVectors (int dimension, double dotProduct, double magnitudeOne, double magnitudeTwo, double magnitudeCP) {
		double angle = 0.0;
		if (dimension == 2) {
			angle = Math.acos(dotProduct / (magnitudeOne * magnitudeTwo)) * (180/Math.PI);
		}
		if (dimension == 3) {
			angle = Math.asin(magnitudeCP / (magnitudeOne * magnitudeTwo) * (180/Math.PI));
		}
		return angle;
	}
	
	static Double answer (String typeOfOperation) {
		System.out.printf("%s", typeOfOperation);
	}
	
	public static void main(String[] args) {
		List<Double> vectorA = Arrays.asList(2.0, 9.0, -3.0);
		List<Double> vectorB = Arrays.asList(0.0, 3.0, -1.0);
		List<Double> vectorC = Arrays.asList(4.0, 2.0, -1.0);
		double scalar = 3;
		String typeOfOperation = "A";
		double magnitudeOfA = magnitude(vectorA);
		double magnitudeOfB = magnitude(vectorB);
		double magnitudeOfC = magnitude(vectorC);
		double dotProductAB = dotProduct(vectorA, vectorB);
		List<Double> scalarProductA = scalarProduct(scalar, vectorA);
		List<Double> crossProductAB = crossProduct(vectorA, vectorB);
		double magnitudeOfCP = magnitude(crossProductAB);
		List<Double> unitVectorCPAB = unitVector(crossProductAB, magnitudeOfCP);
		double angleBetweenAB = angleBetweenVectors(vectorA.size()-1, dotProductAB, magnitudeOfA, magnitudeOfB, magnitudeOfCP);
		answer(angleBetweenAB);
	}
}
