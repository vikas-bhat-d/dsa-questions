public class SolidRombus {
    public static void main(String[] args) {
        int n=5;

        for (int i=1;i<=n;i++){

            for(int j=1;j<=n-i;j++){
                System.err.print("  ");
            }
            for(int j=1;j<=5;j++){
                System.err.print("* ");
            }
            System.out.println();
        }
    }
}
