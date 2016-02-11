package br.com.jpb;

import org.junit.Assert;
import org.junit.Test;

public class GenderRecognitionPtBrTest {

	@Test
	public void test() {
		final String[] maleFullNames = {"João Paulo", "Ronal Sergio", "Wellington Romão", "Raphael Lacerda"};
		final String[] femaleFullNames = {"Beatriz Santos", "Thais", "Andressa Magalhães"};

		final GenderRecognitionPtBr genderRecognition = new GenderRecognitionPtBr();
		for (String maleFullName : maleFullNames) {
			Assert.assertEquals(1, genderRecognition.recognizeFullName(maleFullName));
		}
		for (String femaleFullName : femaleFullNames) {
			Assert.assertEquals(0, genderRecognition.recognizeFullName(femaleFullName));
		}
	}
}
