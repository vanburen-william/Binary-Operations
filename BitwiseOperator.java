import java.util.ArrayList;
import java.util.List;

public class BitwiseOperator {
    private static String[] namesStr = {
            "CONTRADICTION", "NOT OR", "IS IMPLIED", "NOT PRIMARY PROPOSITION", "DOES NOT IMPLY", "NOT SECONDARY PROPOSITION", "EXCLUSIVE OR", "NOT AND",
            "AND", "IF AND ONLY IF", "SECONDARY PROPOSITION", "IMPLIES", "PRIMARY PROPOSITION", "IS NOT IMPLIED", "OR", "TAUTOLOGY"
    };
    private static String[] codesStr = {
            "C", "NOR", "LIMP", "NP", "NRIMP", "NQ", "XOR", "NAND",
            "AND", "IFF", "Q", "RIMP", "P", "NLIMP", "OR", "T"
    };
    private static ArrayList<String> names = new ArrayList<>(List.of(namesStr));
    private static ArrayList<String> codes = new ArrayList<>(List.of(codesStr));

    public static  int operate(String p, String o, String q){
        return operate(codes.indexOf(p), codes.indexOf(o), codes.indexOf(q));
    }

    public static int operate(int p, int o, int q){
        int primaryOperand = p % 16;
        int operator = o % 16;
        int secondaryOperand = q % 16;
        int retInt = 0;
        int bit;
        for (int i = 0; i < 4; i++){
            bit = (int) Math.pow(2.0, Double.valueOf(i));
            if ((primaryOperand &  bit) == bit) {
                if ((secondaryOperand & bit) == bit) { //(1,1)
                    retInt += (bit * ((operator & 8) / 8));
                }
                else{ //(1,0)
                    retInt += (bit * ((operator & 4) / 4));
                }
            } else {
                if ((secondaryOperand & bit) == bit) { //(0,1)
                    retInt += (bit * ((operator & 2) / 2));
                } else { //(0,0)
                    retInt += (bit * (operator & 1));
                }
            }
        }
        return retInt;
    }
    public static void main(String[] args){
//        String test;
//        for (int i = 0; i < codes.size(); i++){
//            for (int j = 0; j < codes.size(); j++){
//                for (int k = 0; k < codes.size(); k++){
//                    if (k == 0){
//                        System.out.print(codes.get(i) + ", " + codes.get(j) + ": ");
//                    }
//                    test = codes.get(BitwiseOperator.operate(i, j, k));
//                    System.out.print(test);
//                    if (k < 15){
//                        System.out.print(", ");
//                    }
//                }
//                System.out.println();
//            }
//        }
        int testInt = 0;
        for (int i = 0; i < codes.size(); i++){
            for (int j = 0; j < codes.size(); j++){
                for (int k = 0; k < codes.size(); k++){
                    if (k == 0){
                        System.out.print(i + ", " + j + ": ");
                    }
                    testInt = BitwiseOperator.operate(i, j, k);
                    System.out.print(testInt);
                    if (k < 15){
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
//        test = codes.get(BitwiseOperator.operate(codes.get(5), "XOR", codes.get(3)));
//        System.out.println(test);
    }
}