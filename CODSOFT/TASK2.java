import java.util.Scanner;
public class TASK2 {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int numofSubjects=sc.nextInt();
    int marks[]=new int[numofSubjects];
    for(int i=0;i<numofSubjects;i++)
    {
        System.out.print("Subject "+(i+1)+" Marks are : ");
        marks[i]=sc.nextInt();
    }
    int totalmarks=totalmarks(marks);
    double averagePercentage=(double) totalmarks/numofSubjects;
    char Grade;
    if(averagePercentage>=90)
    {
        Grade='A';
    }
    else if(averagePercentage>=80)
    {
        Grade='B';
    }
    else if(averagePercentage>=70)
    {
        Grade='C';
    }
    else if(averagePercentage>=60)
    {
        Grade='D';
    }
    else if(averagePercentage>=40)
    {
        Grade='E';
    }
    else
    {
        Grade='F';
    }
    System.out.println("Total marks are : "+totalmarks);
    System.out.println("Average Percentage : "+averagePercentage);
    System.out.println("Grade : "+Grade);
    }


    public static int totalmarks(int marks[])
    {
        int i,sum=0;
        for(i=0;i<marks.length;i++)
        {
            sum=sum+marks[i];
        }
        return sum;
    }
}
