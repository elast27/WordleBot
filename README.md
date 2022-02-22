# WordleBot

Hi there! This is a little Wordle bot side project I am using to efficiently solve the daily Wordle.

## Explanation of the Code
The bot uses user input in four seperate places:
1. `String contains = "_____"` - this is the *green letters*. Any letter in the correct location should be added in this string. For example, if the correct word is **SHARK** and your guess is **SHAME**, the string should look like `'sha__'`. This string MUST be 5 characters, with underscores (\_) representing unknown letters.
2. `String exclude_letters = ""` - this is the gray letters. Any character that is not in the puzzle can be added in this string. Using the above example, the `exclude_letters` string would be `"rk"`.
3. `String include_letters = ""` - this field is for any yellow or green letter. This tells the bot to only search for words containing these letters.
4. `char[][] letters_not` - this 2D array represents the locations where we know a letter is incorrect. If a guess contains a yellow `'p'` in the 2nd slot, you will add the char `'p'` to `letters_not[1]`. 
Once you provide the bot this information, it will format a request to an API which will return a list of valid words to guess.
The bot then filters these remaining words based on the user input, and scores each word, explained below.

## Word Scoring Algorithm
The bot scores each word based on how likely it is to reduce the remaining sample size after the guess, eventually getting to just one word remaining.
It adds up the frequency of every letter in the remaining word list, then calculates each word's score by adding up the frequencies.
HOWEVER, each unique letter in a word is counted only once when calculating word score. For example. If the two remaining words are *otter* and *other*, *other* will have a score of 10 (2 o's, 3 t's, 1 h, 2 e's, 2 r's). *otter* however will only have a score of 9, as the second t will not count towards the word's score calculation.

I understand that this algorithm definitely has some flaws. It does not necessarily consider the probability of the position of each letter, which would be an improvement to results but detrimental to the running speed.

## Installation
Feel free to clone this repo or download the code base. The project uses Maven to install Jackson Databind, the only necessary dependency. No other special installation is required

## Conclusion
Any questions or suggestions can be directed to me at [eric.l.last@gmail.com](mailto:eric.l.last@gmail.com)
Thanks for taking the time to check this out :)
