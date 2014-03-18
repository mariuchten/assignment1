
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class StockSpan {

    public static void main(String[] args) {
		  StockSpan obj = new StockSpan();
    if ("-s".equals(args[0])){
        obj.stack();
        }else if("-n".equals(args[0])) {
        obj.naive();
        }else if("-b".equals(args[0])){
		obj.time();
       }else{

		   }
}
    public void naive() {

        String csvFile = "DJIA.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int x = 0;//metrhths gia na mein diavasei thn prwth grammh tou excell
        int n = 0;
        int p = 0;
        boolean span_end;
        double d;
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Double> doubleList = new ArrayList<Double>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (((line = br.readLine()) != null)) {
                if (x != 0) {

                    // use comma as separator
                    String[] dj = line.split(cvsSplitBy);
                    d = Double.parseDouble(dj[1]);

                    stringList.add(dj[0]);
                    doubleList.add(d);

                }
                x = 1;

            }//while
            int size = doubleList.size();

            int k = 0;
            double w;
            double q;
            int[] f = new int[size];
            for (int i = 0; i < size; ++i) {
                k = 1;
                span_end = false;

                while ((i - k >= 0) && (!span_end)) {
                    w = doubleList.get(i - k);
                    q = doubleList.get(i);
                    if (w < q) {
                        ++k;
                    }//end if
                    else {
                        span_end = true;
                    }

                }//end while
                f[i] = k;
            }//end for
            for (int i = 0; i < size; ++i) {
                System.out.println(f[i]);

            }
            System.out.println("Naive");
        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

    }

    public void time() {

        String csvFile = "DJIA.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int x = 0;//metrhths gia na mein diavasei thn prwth grammh tou excell
        int n = 0;
        int p = 0;
        boolean span_end;
        double d;
        ArrayList<String> stringList = new ArrayList<String>();
        ArrayList<Double> doubleList = new ArrayList<Double>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (((line = br.readLine()) != null)) {
                if (x != 0) {

                    // use comma as separator
                    String[] dj = line.split(cvsSplitBy);
                    d = Double.parseDouble(dj[1]);

                    stringList.add(dj[0]);
                    doubleList.add(d);

                }
                x = 1;

            }//while
            int size = doubleList.size();

            int k = 0;
            double w;
            double q;
            int i;
            int[] f = new int[size];
            long startTime = System.currentTimeMillis();
            for (int y = 0; y <= 100; ++y) {
                for ( i = 0; i < size; ++i) {
                    k = 1;
                    span_end = false;

                    while ((i - k >= 0) && (!span_end)) {
                        w = doubleList.get(i - k);
                        q = doubleList.get(i);
                        if (w < q) {
                            ++k;
                        }//end if
                        else {
                            span_end = true;
                        }
                    }//end while
                    f[i] = k;
                }//end for
            }
            long endTime = System.currentTimeMillis();

            System.out.println("Naive implementation took:" + (endTime - startTime) + "millis");



            Stack <Integer>b=new <Integer>Stack();
            int c;
            b.push(0);
           // System.out.println(b.pop());
           //b.empty();
           int[] spann=new int[size];
           spann[0]=1;
  startTime = System.currentTimeMillis();
            for (int y = 0; y <= 100; ++y) {
           for (i=1;i<size;++i){
			  while((!b.empty())&&(doubleList.get(b.peek())<doubleList.get(i))){
				  b.pop();
				  }//end while
				  if (b.empty()){
					  spann[i]=i+1;
					  }else
					  {
					spann[i]=i-(b.peek());	  }
					b.push(i);
			   }//end for
		   }
			     endTime = System.currentTimeMillis();

            System.out.println("Stack implementation took:" + (endTime - startTime) + "millis");




        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");

    }
    public void stack(){

		 String csvFile = "DJIA.csv";
		        BufferedReader br = null;
		        String line = "";
		        String cvsSplitBy = ",";
		        int x = 0;//metrhths gia na mein diavasei thn prwth grammh tou excell
		        int n = 0;
		        int p = 0;
		        boolean span_end;
		        double d;
		        ArrayList<String> stringList = new ArrayList<String>();
		        ArrayList<Double> doubleList = new ArrayList<Double>();

		        try {

		            br = new BufferedReader(new FileReader(csvFile));
		            while (((line = br.readLine()) != null)) {
		                if (x != 0) {

		                    // use comma as separator
		                    String[] dj = line.split(cvsSplitBy);
		                    d = Double.parseDouble(dj[1]);

		                    stringList.add(dj[0]);
		                    doubleList.add(d);

		                }
		                x = 1;

		            }//while
            int size = doubleList.size();

            Stack <Integer>b=new <Integer>Stack();
            int c;
            b.push(0);
           // System.out.println(b.pop());
           //b.empty();
           int[] spann=new int[size];
           spann[0]=1;


           for (int i=1;i<size;++i){
			  while((!b.empty())&&(doubleList.get(b.peek())<doubleList.get(i))){
				  b.pop();
				  }//end while
				  if (b.empty()){
					  spann[i]=i+1;
					  }else
					  {
					spann[i]=i-(b.peek());	  }
					b.push(i);
			   }//end for


              for (int y = 0; y <size; ++y) {
            System.out.println(spann[y]);

		}
		 System.out.println("Stack");




        }//end try
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");


		}

}
