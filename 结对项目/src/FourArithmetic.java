import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class FourArithmetic {    private static Random random = new Random();
    public static int valueSize;

    //主函数
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("请输入产生几以内的数字：");
        valueSize=sc.nextInt();
        System.out.println("请输入产生多少个运算表达式：");
        int number=sc.nextInt();
        int rightcount[]=new int[number+2];
        int wrongcount[]=new int[number+2];
        int right1=0;
        int wrong1=0;
        String[] results=new String[number];int i;
        for( i=0;i<number;i++){

            String subject[]=new String[2];//定义生成的题目
            int a= (int) (random.nextInt(valueSize));//分子
            int b= (int) (random.nextInt(valueSize));//分母
            int c= (int) (random.nextInt(valueSize));//另一个分子
            int d= (int) (random.nextInt(valueSize));//另一个分母
            int operator;//运算符
            operator= (int) (random.nextInt(4));
            if(b!=0&&d!=0) {//分母均不为0时生成带有分数的计算题，同时计算结果
                if(operator==0) {
                    int molecule=a*d+b*c;
                    int denominator=b*d;
                    subject[0]=inspect(a,b)+'+'+inspect(c,d)+'=';
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule, denominator);

                }
                if(operator==1&&a*d-b*c>=0) {
                    int molecule=a*d-b*c;
                    int denominator=b*d;
                    subject[0]=inspect(a,b)+'-'+inspect(c,d)+'=';
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==1&&a*d-b*c<0) {
                    int molecule=b*c-a*d;
                    int denominator=b*d;
                    subject[0]=inspect(a,b)+'-'+inspect(c,d)+'=';
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==2) {
                    int molecule=a*c;
                    int denominator=b*d;
                    subject[0]=inspect(a,b)+'×'+inspect(c,d)+'=';
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==3&&c!=0) {
                    int molecule=a*d;
                    int denominator=b*c;
                    subject[0]=inspect(a,b)+'÷'+inspect(c,d)+'=';
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==3&&c==0) {
                    break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=biaodashi(a,b)+'÷'+biaodashi(c,d)+'=';
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/

                }

            }
            else {//分母至少一个为0时生成只含有整式的运算式，同时计算结果
                b=1; d=1;
                if(operator==0) {
                    int molecule=a*d+b*c;
                    int denominator=b*d;
                    subject[0]=a+"+"+c+"=";
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule, denominator);

                }
                if(operator==1&&a*d-b*c>=0) {
                    int molecule=a*d-b*c;
                    int denominator=b*d;
                    subject[0]=a+"-"+c+"=";
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==1&&a*d-b*c<0) {
                    int molecule=b*c-a*d;
                    int denominator=b*d;
                    subject[0]=c+"-"+a+"=";
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule,denominator);

                }
                if(operator==2) {
                    int molecule=a*c;
                    int denominator=b*d;
                    subject[0]=c+"×"+a+"=";
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule, denominator);

                }
                if(operator==3&&c!=0) {
                    int molecule=a*d;
                    int denominator=b*c;
                    subject[0]=a+"÷"+c+"=";
                    System.out.println(subject[0]);
                    results[i]=aboutPoints(molecule, denominator);

                }
                if(operator==3&&c==0) {
                    break;
    		/*c=1;
    		int fenzi=a*d;
    		int fenmu=b*c;
    		expArr[0]=a+"÷"+c+"=";
    		System.out.println(expArr[0]);
    		results[i]=reductionofFraction(fenzi, fenmu);*/

                }

            }
            FileWriter fw = null;
            try {

                File f=new File("Exersies.txt");//题目写入
                fw = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(subject[0]!=null) {
                PrintWriter pw = new PrintWriter(fw);
                pw.println(i+1+"."+subject[0]);
                pw.flush();
                try {
                    fw.flush();
                    pw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}FileWriter fn = null;
            try {

                File f=new File("Answer.txt");//答案写入
                fn = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }if(subject[0]!=null) {
                PrintWriter pn = new PrintWriter(fn);
                pn.println(i+1+"."+results[i]);
                pn.flush();
                try {
                    fn.flush();
                    pn.close();
                    fn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("输入ok提交！");
        Scanner input=new Scanner(System.in);
        String submit=input.nextLine();
        if(submit.equals("ok")){
            String array[]=new String[number];
            try
            {   int k=0;

                FileReader fr = new FileReader("E:\\Study\\IDEA_code\\结对项目\\Answer.txt");
                BufferedReader br = new BufferedReader(fr);
                String s ;
                while((s = br.readLine())!=null) {//读取小学生的答案
                    array[k]=s;	k++;
                }br.close();
                fr.close();
            }catch(IOException e){
                System.out.println("指定文件不存在");
            }
            for(int j=0;j<number;j++){
                if(array[j].equals(results[j])) {//验证答案，统计正确和错误的个数

                    rightcount[j]=j+1;
                    right1++;
                }
                else {

                    wrongcount[j]=j+1;
                    wrong1++;
                }
            }
            FileWriter fg = null;
            try {
                //反馈正确与错误题目的信息
                File f=new File("Grade.txt");
                fg = new FileWriter(f, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter pg = new PrintWriter(fg);
            pg.println(" ");
            pg.print("Correct:"+right1+"(");
            for (int j = 0; j <= number; j++) {
                if (rightcount[j] != 0) {
                    pg.print(rightcount[j] + ",");
                }
            }
            pg.println(")");
            pg.print("Wrong:"+wrong1+"(");
            for (int j = 0; j <= number; j++) {
                if (wrongcount[j] != 0) {
                    pg.print(wrongcount[j] + ",");
                }
            }
            pg.print(")");
            pg.flush();
            try {
                fg.flush();
                pg.close();
                fg.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //判断假分数，并化假分数为带分数
    public static String inspect(int a,int b) {
        if(a>=b) {
            int c;
            c=a/b;
            int d;
            d=a%b;
            {if(d==0) {return c+"";}
                return c+"'"+d+"/"+b;}
        }return a+"/"+b;
    }

    // 分数约分，用于计算结果
    public static String aboutPoints(int a, int b) {
        int y = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                y = i;
                break;
            }
        }
        int z = a / y;// 分子
        int m = b / y;// 分母
        if (z == 0) {
            return "0";
        }
        if(m==1) return z+"";
        else  return inspect(z,m);

    }


}
