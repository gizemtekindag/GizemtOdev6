import java.util.*;

public class KelimeOyunu {
    public static void main(String[] args) {

 /*       List<String> kelimeDizi= new ArrayList<>();

        kelimeDizi.add("kalem");
        kelimeDizi.add("elalem");
        kelimeDizi.add("kelam");
        kelimeDizi.add("kelime");*/

        //System.out.println(kelimeDizi);

        String [] kelimeDizi= {"kalem", "elalem", "kelam", "kelime"};

        String [] tekrarHarfliKelimeler=tekrarlıHarfliKelimeleriBul(kelimeDizi);

        if (tekrarHarfliKelimeler.length==2){
            String rastgeleKelime= rastgeleKelimeOluşturma(tekrarHarfliKelimeler);
            System.out.println("Tekrar eden harf içeren iki kelime :" + Arrays.toString(tekrarHarfliKelimeler));
            System.out.println("Oluşturulan metin: " + rastgeleKelime);
        } else {
            System.out.println("Yeterli sayıda tekrar eden harf içeren kelime yok");
        }


    }

    public static boolean tekrarEdenHarfVarMı (String k){
        HashSet<Character> harfler = new HashSet<>();
        for (char c : k.toCharArray()){
            if(!harfler.add(c)){
                return true;
            }
        }
        return false;
    }

    public static String[] tekrarlıHarfliKelimeleriBul(String[] kelimeListesi){
        List<String> tekrarlıHKelimeler = new ArrayList<>();

        for (String kelime : kelimeListesi){
                if(tekrarEdenHarfVarMı(kelime)){
                    tekrarlıHKelimeler.add(kelime);
                }
            if (tekrarlıHKelimeler.size()==2){
                break;
            }
        }
        return tekrarlıHKelimeler.toArray(new String[0]);
    }

    public static String rastgeleKelimeOluşturma(String[] kelimeler){
        StringBuilder harflerinBirleşimi=new StringBuilder(kelimeler[0]).append(kelimeler[1]);
        List<Character> harfListesi= new ArrayList<>();

        for(char h : harflerinBirleşimi.toString().toCharArray()){
            harfListesi.add(h);
        }

        Collections.shuffle(harfListesi);

        StringBuilder rastgeleKelime = new StringBuilder();
        for (char h: harfListesi){
            rastgeleKelime.append(h);
        }
        return rastgeleKelime.toString();
    }
}
