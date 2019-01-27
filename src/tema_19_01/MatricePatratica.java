package tema_19_01;

import java.util.*;

public class MatricePatratica {
	private int[][] matrice;

	public MatricePatratica(int n) {
		matrice = new int[n][n];

	}

	/**
	 * Aceasta metoda va fi folosita in test pentru a umple matricea cu numere
	 * intregi consecutive.
	 * 
	 * @param n            = numarul de linii si coloane pt matricea patratica
	 * @param startElement = primul element al matricii.
	 */
	public MatricePatratica(int n, int startElement) {
		this(n);
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matrice[i][j] = startElement++;
			}
		}
	}

	public void fillMatriceRandomly() {
		Random rand = new Random();
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matrice[i][j] = rand.nextInt(100);
			}
		}
	}

	public int calculateSumOfMainDiagonal() {
		int sum = 0;
		for (int element : returnMainDiagonal(matrice)) {
			sum += element;
		}
		return sum;
	}

	public int calculateSumOfSecondaryDiagonal() {
		int sum = 0;
		for(int element : returnSecondaryDiagonal(matrice)) {
			sum += element;
		}
		return sum;
	}
	
	public int getMaxOnMainDiagonal() {
		return getMax(returnMainDiagonal(matrice));
	}

	
	
	public int getMaxOnSecondaryDiagonal() {
		return getMax(returnSecondaryDiagonal(matrice));
	}
	

	/**
	 * @param n - number of line, not index
	 */
	public String printElementsOnLine(int n) {
		String result = Arrays.toString(matrice[n-1]);
		System.out.println(result);
		return result;
	}
	
	private int[] returnMainDiagonal(int[][] matrice) {
		int[] mainDiagonal = new int[matrice.length];
		for (int i = 0; i < matrice.length; i++) {
			mainDiagonal[i]= matrice[i][i];
		}
		return mainDiagonal;
	}
	
	private int[] returnSecondaryDiagonal(int[][] matrice) {
		int[] secondaryDiagonal = new int[matrice.length];
		int j = matrice.length - 1;
		for(int i = 0; i < matrice.length; i++) {
			secondaryDiagonal[i] = matrice[i][j];
			j--;
		}
		return secondaryDiagonal;
	}
	
	private int getMax(int[] array) {
		int max = array[0];
		for(int element : array) {
			if (max < element) {
				max = element;
			}
		}
		return max;
	}

	public int[][] getMatrice() {
		return matrice;
	}
}
