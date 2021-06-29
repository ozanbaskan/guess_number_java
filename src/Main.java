import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int interval = rand.nextInt(100) + 1;
        int number = rand.nextInt(interval);
        int tries = interval / 10 + 1;
        int guessNumber = 0;
        int guess;
        boolean winned = false;
        boolean troll = false;

        Scanner input = new Scanner(System.in);

        int[] guesses = new int[tries];

        System.out.println("1-" + interval +" arasında rastgele bir sayı seçildi, tahmin etmek için " + tries + "  hakkınız var.");

        while (tries > 0)
        {

            System.out.print((guessNumber + 1) + ". tahmininizi giriniz: ");
            guess = input.nextInt();
            if (guess < 1 || guess > interval)
            {
                System.out.println("Lütfen 1-" + interval + " arası bir sayı giriniz." );
                if (!troll)
                {
                    troll = true;
                    continue;
                }
                else
                {

                    if (++guessNumber == tries)
                    {
                        break;
                    }
                    System.out.println("Tahmin haklarınız azaldı! Kalan hakkınız: " + (tries - (guessNumber)));
                    continue;
                }

            }
            else
            {
                troll = false;
            }
            if (guess == number)
            {
                System.out.println("Tahmininiz doğru! Kazandınız!");
                if (guesses[0] != 0)
                {
                    System.out.print("Önceki tahminleriniz: ");
                    print(guesses);
                }
                System.out.println("####################################");
                winned = true;
                break;
            }
            else
            {
                guesses[guessNumber++] = guess;
                if (guess > number)
                {
                    System.out.println("Girdiğiniz sayı seçilen sayıdan büyük!");
                }
                else
                {
                    System.out.println("Girdiğiniz sayı seçilen sayıdan küçük!");
                }

                if (guessNumber == tries)
                {
                    break;
                }
                else
                {
                    System.out.println(tries - guessNumber + " hakkınız kaldı.");
                }
            }

        }

        if (!winned)
        {
            System.out.println("Hakkınız kalmadı! Oyunu kaybettiniz! :(");

            if (guesses[0] != 0)
            {
                System.out.print("Önceki tahminleriniz: ");
                print(guesses);
            }
            System.out.println("####################################");
        }

    }

    static void print(int[] a)
    {
        int length = a.length;
        System.out.print("[");
        for (int i = 0; i < length;i++)
        {

            if (i != length - 1)
            {
                if (a[i] != 0) System.out.print(a[i] + ", ");
            }
            else
            {
                if (a[i] != 0) System.out.print(a[i] + "]");
            }
        }
        System.out.println("");
    }
}