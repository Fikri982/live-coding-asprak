package alprokom2;

public class PencarianKataKunci {
    public static void main(String[] args) {

        String[] list = {
                "ab", "cba", "abc", "axbxc",
                "ddd", "abc", "cxab", "aabbcc"
        };

        String target = "abc";

        // Menggunakan array String[] biasa
        String[] result = filterSearch(list, target);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static String[] filterSearch(String[] searchResult, String target) {

        // Buat array sementara dengan ukuran maksimal
        String[] tempHasil = new String[searchResult.length];
        
        // Siapkan penghitung untuk elemen yang cocok
        int matchCount = 0;

        for (int i = 0; i < searchResult.length; i++) {

            String current = searchResult[i];

            if (containsAllChars(current, target)) {
                tempHasil[matchCount] = current;
                matchCount++;
            }
        }

        String[] hasilAkhir = new String[matchCount];
        for (int i = 0; i < matchCount; i++) {
            hasilAkhir[i] = tempHasil[i];
        }

        return hasilAkhir;
    }

    public static boolean containsAllChars(String text, String target) {

        for (int i = 0; i < target.length(); i++) {

            char c = target.charAt(i);

            int countTarget = countChar(target, c);
            int countText = countChar(text, c);

            if (countText < countTarget) {
                return false;
            }
        }

        return true;
    }

    public static int countChar(String str, char c) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }
}
