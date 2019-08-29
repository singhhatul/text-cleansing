package com.stackroute.succour;

import com.stackroute.succour.nonalphanumericremover.RemoveSpecialCharacter;
import com.stackroute.succour.spellchecker.SpellCorrector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.io.IOException;


@ComponentScan(basePackages = "com.stackroute.succour")
@Import({RemoveSpecialCharacter.class, SpellCorrector.class})
@SpringBootApplication
public class TextCleansingApplication {
	public static void main(String[] args) throws IOException {

	//	SpringApplication.run(TextCleansingApplication.class, args);

	System.out.println(SpellCorrector.resultString());
	}
}

