import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int size;
        System.out.println("Enter the number of elements in the array");
        size=sc.nextInt();
        int a[]=new int[size];

        System.out.println("Enter the array elements:");
        for(int i=0;i<size;i++)
            a[i]=sc.nextInt();

        CountingSort cs=new CountingSort();

        System.out.println("Before Sorting:");
        cs.printArray(a, size);
        cs.countingSort(a, size);
        System.out.println("After Sorting:");
        cs.printArray(a, size);
        sc.close();
    }
}