package com.chainsys.introduction;

public class Pattern {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			int n = 5;

			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = i; k >= 1; k--) {
				System.out.print(k+" ");
			}
			for (int l = 2; l <= i; l++) {
				System.out.print(l+" ");
			}
			System.out.println();
		}
		for (int i = 4; i >= 1; i--) {
			int n = 4;

			for (int j = 0; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = i; k >= 1; k--) {
				System.out.print(k+" ");
			}
			for (int l = 2; l <= i; l++) {
				System.out.print(l+" ");
			}

			System.out.println();
		}

	}
}