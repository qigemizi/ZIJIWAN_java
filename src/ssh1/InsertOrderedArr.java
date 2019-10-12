package ssh1;

/**
 * ��Ŀ������һ�����������{13, 15, 19, 28, 33, 45, 78, 106}��
 * ������������д洢һ��Ԫ��50������֤������黹������ģ�
 * ��ô���Ԫ�صĴ洢�ĽǱ���λ�ȡ��
 * ˼·�����ö��ֲ��ҷ�������󷵻�minֵ���ɡ�
 * ����: 1)����arr��key���洢��Ŀ�е�ֵ������max��min��mid���ֱ��¼��������
 *       2)ʹ��whileѭ���ṹ�����ƣ�ѭ������Ϊ min <= max�����򷵻�min
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
        System.out.println(key + "Ӧ�ò��뵽�����λ���±�Ϊ�� " + index);
         
        int[] arr1 = new int[arr.length + 1];
        insertArr(arr, arr1, key, index);
        printArr(arr1);
    }
    //��ӡ����
    private static void printArr(int[] arr1)
    {
        System.out.print("����Ԫ�غ������Ϊ�� [");
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
            //�����۰�
            int mid = (min + max) >> 1;
        	System.out.println("mid="+mid);
            //���keyֵ���м�ֵ������Ҫ����λ����������Ұ��
            if(key > arr[mid])
            {
                min = mid + 1;
            }
            //���keyֵ���м�ֵС������Ҫ����λ�������������
            else if(key < arr[mid])
            {
                max = mid - 1; 
            }
            //keyֵ���м�ֵһ������ֱ�ӷ���index = mid
            else
            {
                return mid;
            }
        }
        //����±�min > max��ֻ��length=0ʱ���㰡���򷵻�minλ�ü�Ϊ��Ҫ�����λ��
        return min;
    }
    /*
     * ���裺
     * ѭ������arr�����i < index,��arr1[i] = arr[i];
     *                ���i == index����arr1[i] = key;
     *                ����arr1[i] = arr[i-1];
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