package crapsgame;
/* @author sumeyral

 */

import java.util.Scanner;

public class Craps {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Kaç kere oynamak istediğinizi girin (Sizin yerinize her oyun simule edilecektir):");
        int val = Integer.parseInt(kb.nextLine());
        Game.run(val);
    }
}
class Game{
    public static void run(int val)
    {
        int win=0;

        for(int i=1; i<=val; i++) {
            int res= throwDice();
            System.out.printf("Deneme[%d] zarların toplam değeri: %d%n",i,res);

            switch(res) {
                case 7:
                case 11:
                    win++;
                    System.out.printf("%d attığınız için kazandınız%n",res);
                    break;
                case 2:
                case 3:
                case 12:
                    System.out.printf("CRAPS!%n",res);
                    break;
                default:
                    System.out.println("Sonuç belli değil, oyuncu tekrar zar atacak");
                    int temp = res;
                    res = throwDice();

                    EXIT_LOOP:
                    if(res == 7) {
                        System.out.printf("%d attığınız için kaybettiniz%n",res);
                        break;
                    }
                    else {
                        while(res!= temp) {
                            res = throwDice();
                            if(res == 7)
                                break EXIT_LOOP;
                        }
                        System.out.printf("%d = %d kazandınız %n",res,temp);
                        win++;
                        break;
                    }
            }
        }

        double pos= (double)win/val;
        System.out.printf("%f",pos);
    }
    private static int throwDice()
    {
        java.util.Random r= new java.util.Random();
        int result = (r.nextInt(6)+1)+ (r.nextInt(6)+1);

        return result;
    }

}