package alprokom2;

public class EnkripsiVokalKonsonan {
    public static void main(String[] args) {
        System.out.println(transform("HELLO WORLD"));
    }

    public static String transform(String x) {
        if (x == null) {
            return "";
        } 
        
        String tanpaStrip = "";
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != '-') {
                tanpaStrip += x.charAt(i);
            }
        }
        String hasil = "";
        for (int i = 0; i < tanpaStrip.length(); i++) {
            char c = tanpaStrip.charAt(i);

            if (c == ' ') {
                hasil += "=";
                continue;
            }

            boolean vokal = isVokal(c);
            boolean pakaiHash = false;
            if (vokal) {
                //  kondisi diantara dua vokal
                if(i > 0 && i < tanpaStrip.length() - 1) {
                    if (isVokal(tanpaStrip.charAt(i - 1)) && isVokal(tanpaStrip.charAt(i + 1))) {
                        pakaiHash = true;
                    }
                }
            }
            // kondisi awal kata dan huruf kedua bukan vokal
            if ( i == 0 && tanpaStrip.length() > 1 && !isVokal(tanpaStrip.charAt(1))) {
                pakaiHash = true;
            
            }

            //  transformasi vokal dan konsonan
            if(vokal) {
                hasil += "|" + c;
            } else {
                hasil += c + "|";
            }

            if(vokal &&pakaiHash) {
                hasil += "#";
            } else if (i != x.length() - 1) {
                hasil += "%";
            }
        }
        return hasil;
    }

    public static boolean isVokal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

    }
}
