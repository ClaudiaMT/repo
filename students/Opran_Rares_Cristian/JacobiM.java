package x;
import java.util.*;
import java.util.Scanner;
public class JacobiM {

	static double mat[][];
	static double b[], x[], y[];
	static int n;
	static double eps;
	static long nrMax;
	
	public static void main(String[] args) {
		eps = 0.0001;
		nrMax = 10000;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		mat = new double[n][n];
		b = new double[n];
		x = new double[n];
		y = new double[n];
		double norm;
		for (int i = 0; i <= n-1; i++)
			for (int j = 0; j <= n-1; j++)
				mat[i][j] = sc.nextDouble();
		for (int i = 0; i < n; i++)
			b[i] = sc.nextDouble();
		int nrCrt = 0;
		do {
			for (int i = 0; i <= n-1; i++)
				y[i] = (1.00 / mat[i][i]) * (b[i] - sumaU(i) - sumaM(i));
			norm = norm();
			for (int i = 0; i <= n-1; i++)
				x[i] = y[i];
			nrCrt++;
		} while (norm >= eps && nrCrt < nrMax);

		for (int i = 0; i <= n-1; i++)
			System.out.println(y[i]);
		sc.close();
	}
	static double norm() {
		double max = Math.abs(x[0] - y[0]);
		for (int i = 1; i <= n-1; i++) {
			double calc = Math.abs(x[i] - y[i]);
			if (calc > max)
				max = calc;
		}
		return max;
	}

	static double suma(int rand) {
		double suma = 0.0;
		for (int i = 0; i <= n-1; i++)
			if (i != rand)
				suma += mat[rand][i] * x[i];

		return suma;
	}

	
	
	static double sumaM(int rand) {
		double suma = 0.0;
		for (int i = rand; i <= n-1; i++)
			if (i != rand)
				suma += mat[rand][i] * x[i];
		return suma;
	}

	
	static double sumaU(int rand) {
		double suma = 0.0;
		for (int i = 0; i < rand; i++)
			if (i != rand)
				suma += mat[rand][i] * y[i];
		return suma;
	}

	
	

		

}