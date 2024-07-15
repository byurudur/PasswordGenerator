package com.passwordgenerator.PasswordGenerator.service;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class PasswordGeneratorService {

    private final List<Character> lettersCapital = Arrays.asList('A', 'B', 'C', 'Ç', 'D', 'E', 'F', 'G', 'H', 'I', 'İ', 'J', 'K', 'L', 'M',
            'N', 'O', 'Ö', 'P', 'R', 'S', 'Ş', 'T', 'U', 'Ü', 'V', 'Y', 'Z');

    private final List<Character> letters = Arrays.asList('a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'h', 'ı', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z');

    private final List<Character> specialCharacters = Arrays.asList('-', '_', '.');

    private final Random random = new Random();

    public String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useSpecialChars) {
        StringBuilder generatedPassword = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (useUppercase) {
                char randomLetterCapital = lettersCapital.get(random.nextInt(lettersCapital.size()));
                generatedPassword.append(randomLetterCapital);
            }

            if (useLowercase) {
                char randomLetter = letters.get(random.nextInt(letters.size()));
                generatedPassword.append(randomLetter);
            }

            if (useSpecialChars) {
                char randomChar = specialCharacters.get(random.nextInt(specialCharacters.size()));
                generatedPassword.append(randomChar);
            }

            int randomNumber = random.nextInt(10);
            generatedPassword.append(randomNumber);
        }

        return generatedPassword.substring(0, Math.min(generatedPassword.length(), length));
    }
}
