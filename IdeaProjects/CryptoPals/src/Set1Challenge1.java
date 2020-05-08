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

class Set1Challenge1 {
    public static void main(String[] args) {
        String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
        byte[] inBytes = stringToHex(hex);
        byte[] outBytes = convertBytesToBase64(inBytes);
        System.out.println(new String(outBytes));
    }

    public static byte[] stringToHex(String in) {
        if (in.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid length");
        }
        byte[] out = new byte[in.length() / 2];
        int index = 0;
        while (index < in.length()) {
            int c = Integer.valueOf(in.substring(index, index + 2), 16);
            out[index / 2] = (byte) c;
            index += 2;
        }
        return out;
    }

    private static final char[] base64chars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'
    };

    public static byte[] convertBytesToBase64(byte[] inBytes) {
        // if not multiple of 3, do something special
        byte[] outBytes = new byte[((inBytes.length + 2) / 3) * 4];
        int outIndex = 0;
        for (int inIndex = 0; inIndex < inBytes.length;) {
            int first = inBytes[inIndex] >> 2;
            int second = ((inBytes[inIndex] & 3) << 4) | (inBytes[inIndex + 1] >> 4);
            int third = ((inBytes[inIndex + 1] & 15) << 2) | (inBytes[inIndex + 2] >> 6);
            int fourth = inBytes[inIndex + 2] & 63;
            outBytes[outIndex] = (byte) base64chars[first];
            outBytes[outIndex + 1] = (byte) base64chars[second];
            outBytes[outIndex + 2] = (byte) base64chars[third];
            outBytes[outIndex + 3] = (byte) base64chars[fourth];
            inIndex += 3;
            outIndex += 4;
        }
        return outBytes;
    }
}