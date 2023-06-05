public class CountingSort {
    private int getMax(int a[],int size)
    {
        int max=a[0];
        for (int i = 1; i < size; i++)
        {
            if(a[i]>max)
                max=a[i];
        }
        return max;
    }

    //method to sort the array using counting sort
    public void countingSort(int[] a, int size)
    {
        int max=getMax(a, size);
        int[] temp = new int[max+1];
        int[] sortedArray = new int[size];
        int i;

        for(i=0; i<size; i++)
            temp[a[i]]++;

        for(i=1;i<=max;i++)
            temp[i]+=temp[i-1];

        for(i=0;i<size;i++)
        {
            sortedArray[temp[a[i]]-1]=a[i];
            temp[a[i]]--;
        }

        //copying sorted array to original array
        for (i = 0; i < size; i++)
            a[i]=sortedArray[i];
    }

    public void printArray(int[] a, int size)
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(a[i]+" --> ");
        }
        System.out.println("END");
    }
}
