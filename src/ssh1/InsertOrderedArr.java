package ssh1;

/**
 * 题目：给定一个有序的数组{13, 15, 19, 28, 33, 45, 78, 106}，
 * 如果往该数组中存储一个元素50，并保证这个数组还是有序的，
 * 那么这个元素的存储的角标如何获取？
 * 思路：利用二分查找法，将最后返回min值即可。
 * 步骤: 1)定义arr，key来存储题目中的值，定义max，min和mid来分别记录二分区间
 *       2)使用while循环结构来控制，循环条件为 min <= max，否则返回min
 * @author liaojianya
 * 2016-11-16
 */
  
public class InsertOrderedArr
{
    public static void main(String[] args)
    {
        int[] arr = new int[] {13, 15, 19, 28, 33, 45, 78, 106};
        int key = 50;
        int index = getInsertIndex(arr, key);
        System.out.println(key + "应该插入到数组的位置下标为： " + index);
         
        int[] arr1 = new int[arr.length + 1];
        insertArr(arr, arr1, key, index);
        printArr(arr1);
    }
    //打印数组
    private static void printArr(int[] arr1)
    {
        System.out.print("插入元素后的数组为： [");
        for(int i = 0; i < arr1.length; i++)
        {
            if(i != arr1.length - 1)
            {
                System.out.print(arr1[i] + ", ");
            }
            else
            {
                System.out.println(arr1[i] + "]");
            }
        }
    }
     
    public static int getInsertIndex(int[] arr, int key)
    {
        int min = 0;
        int max = arr.length - 1;
        System.out.println("min="+min+",max="+max);
        while(min <= max)
        {
            //右移折半
            int mid = (min + max) >> 1;
        	System.out.println("mid="+mid);
            //如果key值比中间值大，则所要插入位置在数组的右半边
            if(key > arr[mid])
            {
                min = mid + 1;
            }
            //如果key值比中间值小，则所要插入位置在数组的左半边
            else if(key < arr[mid])
            {
                max = mid - 1; 
            }
            //key值和中间值一样大，则直接返回index = mid
            else
            {
                return mid;
            }
        }
        //如果下标min > max，只有length=0时满足啊，则返回min位置即为所要插入的位置
        return min;
    }
    /*
     * 步骤：
     * 循环遍历arr，如果i < index,则arr1[i] = arr[i];
     *                如果i == index，则arr1[i] = key;
     *                否则，arr1[i] = arr[i-1];
     * 
     */
    public static void insertArr(int[] arr, int[] arr1, int key, int index)
    {
  
        for(int i = 0; i < arr1.length; i++)
        {
            if (i < index)
            {
                arr1[i] = arr[i];
            }
            else if(i == index)
            {
                arr1[i] = key;
            }
            else
            {
                arr1[i] = arr[i-1];
            }
        }
    }
}