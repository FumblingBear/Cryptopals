/*
 * Cryptopals Set 1 Challenge 1
 *
 * Convert hex to base64
 *
 * The string: 49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d
 * Should produce: SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t
 * Rule: Always operate on raw bytes, never on encoded strings. Only use hex and base64 for pretty-printing.
 *
 */

class Set1Challenge1
{
    public static void main(String[] args)
    {
        String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        // convertHexToDecimal(hex);
    }

    public static String convertHexToBase64()
    {
        String convertedHex;
    }
}