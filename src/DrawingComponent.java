import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DrawingComponent extends JPanel {

    public List<Integer> Array_overall_time_add = new ArrayList<>();

    public List<Integer> Array_overall_time_dell = new ArrayList<>();

    public List<Integer> Array_count = new ArrayList<>();

    public List<Integer> hash_map_overall_time_add = new ArrayList<>();
    public List<Integer> hash_map_count_add= new ArrayList<>();
    public List<Integer> hash_map_overall_time_dell  = new ArrayList<>();

    public int[] xs ={1,10,3,4,5,40,7,8,9,10};
    public int[] ys ={1,2,3,4,5,6,7,8,9,10};
    public DrawingComponent(File path) throws Exception {
        if (!path.exists())throw new Exception("Файл не существует");
        List<String> file_data = new ArrayList<>();
        try (BufferedReader buff = new BufferedReader(new FileReader(path.getAbsolutePath()))){
            String line ="";
            while ((line = buff.readLine())!=null) file_data.add(line);
        }
        int iter=0,type=0;
        for (String line :file_data){
            if(type<30){
                iter++;
                if(iter==7)iter=1;
                if(iter==1)Array_count.add(Integer.parseInt(line));
                if(iter==2)Array_overall_time_add.add(Integer.parseInt(line));
                if(iter==5)Array_overall_time_dell.add(Integer.parseInt(line));

            }
            type++;
            if(type > 30){
                iter++;
                if(iter==7)iter=1;
                if(iter==1)hash_map_count_add.add(Integer.parseInt(line));
                if(iter==2)hash_map_overall_time_add.add(Integer.parseInt(line));

                if(iter==5)hash_map_overall_time_dell.add(Integer.parseInt(line));

             }


        }

    }

    @Override
    protected void paintComponent(Graphics gh) {
        int width = getWidth();
        int height  =getHeight();

        Graphics2D drp = (Graphics2D)gh;
        drp.setColor(Color.BLUE);
        Font font = new Font("Arial", Font.PLAIN, 7);
        drp.setFont(font);
        drp.drawLine(0,height/2,width,height/2);
        drp.drawLine(width/2,height,width/2,0);
        drp.drawLine(0,0,0,height);
        drp.drawLine(0,0,width,0);
        drp.drawLine(width,0,width,height);
        drp.drawLine(0,height,width,height);
        drp.setColor(Color.BLACK);
        ///1
        drp.drawString("1-ArrayList.add",width/6,20);
        drp.drawLine(20,20,20,height/2-20);//ось
        drp.drawLine(20,height/2-20,width/2-20,height/2-20);//ось
        drp.drawString("time-10^5 нс",10,15);
        drp.drawLine(15,25,20,20);
        drp.drawLine(20,20,25,25);
        drp.drawString("0",10,height/2-10);
        drp.drawString("Amount",width/2-40,height/2-10);
        drp.drawLine(width/2-25,height/2-15,width/2-20,height/2-20);
        drp.drawLine(width/2-25,height/2-25,width/2-20,height/2-20);
        //2
        drp.drawString("2-ArrayList.del",width/6,height/2+20);
        drp.drawLine(20,height/2+20,20,height-20);//ось
        drp.drawLine(20,height-20,width/2-20,height-20);//ось
        drp.drawString("time-10^4 нс",10,height/2+15);
        drp.drawLine(15,height/2+25,20,height/2+20);
        drp.drawLine(20,height/2+20,25,height/2+25);
        drp.drawString("0",10,height-10);
        drp.drawString("Amount",width/2-40,height-10);
        drp.drawLine(width/2-30,height-25,width/2-20,height-20);
        drp.drawLine(width/2-30,height-15,width/2-20,height-20);
        //
        drp.drawString("3-HashMap.add",width/2+width/6,20);
        drp.drawLine(width/2+20,20,width/2+20,height/2-20);//ось
        drp.drawLine(width/2+20,height/2-20,width-20,height/2-20);//ось
        drp.drawString("time-10^5 нс",width/2+10,15);
        drp.drawLine(width/2+15,25,width/2+20,20);
        drp.drawLine(width/2+20,20,width/2+25,25);
        drp.drawString("0",10,height-10);
        drp.drawString("Amount",width-40,height/2-10);
        drp.drawLine(width-30,height/2-15,width-20,height/2-20);
        drp.drawLine(width-30,height/2-25,width-20,height/2-20);
        //4
        drp.drawString("4-HashMap.del",width/2+width/6,height/2+20);
        drp.drawLine(width/2+20,height/2+20,width/2+20,height-20);//ось
        drp.drawLine(width/2+20,height-20,width-20,height-20);//ось
        drp.drawString("time-10^4 нс",width/2+10,height/2+15);
        drp.drawLine(width/2+15,height/2+25,width/2+20,height/2+20);
        drp.drawLine(width/2+20,height/2+20,width/2+25,height/2+25);
        drp.drawString("0",width/2+10,height-10);
        drp.drawString("Amount",width-40,height-10);
        drp.drawLine(width-30,height-25,width-20,height-20);
        drp.drawLine(width-30,height-15,width-20,height-20);
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///for 1
        int x_null = 20;
        int y_null = height/2-20;
        int amount=10;
        ArrayList<Integer> x_tmp = new ArrayList<>();
        for(int i = 20;i<width/2-40-(width/2-40)/Array_count.size();i+=(width/2-40)/Array_count.size()){
            drp.fillOval(x_null+i-3,y_null-3,6,6);
            drp.drawString(String.format("%d",amount),x_null+i-10,y_null+12);
            x_tmp.add(x_null+i);
            amount*=10;
        }
        for (int i=0;i<Array_count.size()-1;i++){
            drp.fillOval(x_null-3 ,y_null-Array_overall_time_add.get(i)/100-3,6,6);
            drp.drawString(String.format("%d",Array_overall_time_add.get(i)/100),x_null-14 ,y_null-Array_overall_time_add.get(i)/100);
        }

        for (int i=0;i<Array_count.size()-1;i++){
            if(i==0){
                drp.drawLine(x_null,y_null,x_tmp.get(i)
                        ,y_null - Array_overall_time_add.get(i)/100);
            }
            if(i>0) {
                drp.drawLine(x_tmp.get(i - 1), y_null - Array_overall_time_add.get(i - 1) / 100,x_tmp.get(i), y_null - Array_overall_time_add.get(i) / 100);
                drp.fillOval(x_tmp.get(i)-3
                        ,y_null - Array_overall_time_add.get(i)/100-3,6,6);
                drp.fillOval(x_tmp.get(i-1)-3
                        ,y_null - Array_overall_time_add.get(i-1)/100-3,6,6);
            }
        }
        ///for 2
        x_null = 20;
        y_null = height-20;
        amount=10;
        x_tmp.clear();
        for(int i = 20;i<width/2-40-(width/2-40)/Array_count.size();i+=(width/2-40)/Array_count.size()){
            drp.fillOval(x_null+i-3,y_null-3,6,6);
            drp.drawString(String.format("%d",amount),x_null+i-10,y_null+12);
            x_tmp.add(x_null+i);
            amount*=10;
        }
        for (int i=0;i<Array_count.size()-1;i++){
            drp.fillOval(x_null-3 ,y_null-Array_overall_time_dell.get(i)/10-3,6,6);
            drp.drawString(String.format("%d",Array_overall_time_dell.get(i)/10),x_null-14 ,y_null-Array_overall_time_dell.get(i)/10);
        }

        for (int i=0;i<Array_count.size()-1;i++){
            if(i==0){
                drp.drawLine(x_null,y_null,x_tmp.get(i)
                        ,y_null - Array_overall_time_dell.get(i)/10);

                drp.fillOval(x_tmp.get(i)
                        ,y_null - Array_overall_time_dell.get(i)/10,2,2);
            }
            if(i>0) {
                drp.drawLine(x_tmp.get(i - 1), y_null - Array_overall_time_dell.get(i - 1) / 10,x_tmp.get(i), y_null - Array_overall_time_dell.get(i) / 10);
                drp.fillOval(x_tmp.get(i)-3
                        ,y_null - Array_overall_time_dell.get(i)/10-3,6,6);
                drp.fillOval(x_tmp.get(i-1)-3
                        ,y_null - Array_overall_time_dell.get(i-1)/10-3,6,6);
            }
        }
        //for 3
        x_null = width/2+20;
        y_null = height/2-20;
        amount=10;
        x_tmp.clear();
        for(int i = 20;i<width/2-40-(width/2-40)/hash_map_count_add.size();i+=(width/2-40)/hash_map_count_add.size()){
            drp.fillOval(x_null+i-3,y_null-3,6,6);
            drp.drawString(String.format("%d",amount),x_null+i-10,y_null+12);
            x_tmp.add(x_null+i);
            amount*=10;
        }
        for (int i=0;i<hash_map_count_add.size()-1;i++){
            drp.fillOval(x_null-3 ,y_null-hash_map_overall_time_add.get(i)/10-3,6,6);
            drp.drawString(String.format("%d",hash_map_overall_time_add.get(i)/10),x_null-14 ,y_null-hash_map_overall_time_add.get(i)/10);
        }

        for (int i=0;i<hash_map_count_add.size()-1;i++){
            if(i==0){
                drp.drawLine(x_null,y_null,x_tmp.get(i)
                        ,y_null - hash_map_overall_time_add.get(i)/100);
            }
            if(i>0) {
                drp.drawLine(x_tmp.get(i - 1), y_null - hash_map_overall_time_add.get(i - 1) / 100,x_tmp.get(i), y_null - hash_map_overall_time_add.get(i) / 100);
                drp.fillOval(x_tmp.get(i)-3
                        ,y_null - hash_map_overall_time_add.get(i)/100-3,6,6);
                drp.fillOval(x_tmp.get(i-1)-3
                        ,y_null - hash_map_overall_time_add.get(i-1)/100-3,6,6);
            }
        }
        //for 4
        x_null = width/2+20;
        y_null = height-20;
        amount=10;
        x_tmp.clear();
        for(int i = 20;i<width/2-40-(width/2-40)/hash_map_count_add.size();i+=(width/2-40)/hash_map_count_add.size()){
            drp.fillOval(x_null+i-3,y_null-3,6,6);
            drp.drawString(String.format("%d",amount),x_null+i-10,y_null+12);
            x_tmp.add(x_null+i);
            amount*=10;
        }
        for (int i=0;i<hash_map_count_add.size()-1;i++){
            drp.fillOval(x_null-3 ,y_null-hash_map_overall_time_dell.get(i)/10-3,6,6);
            drp.drawString(String.format("%d",hash_map_overall_time_dell.get(i)/10),x_null-14 ,y_null-hash_map_overall_time_dell.get(i)/10);
        }

        for (int i=0;i<hash_map_count_add.size()-1;i++){
            if(i==0){
                drp.drawLine(x_null,y_null,x_tmp.get(i)
                        ,y_null - hash_map_overall_time_dell.get(i)/10);

                drp.fillOval(x_tmp.get(i)
                        ,y_null - hash_map_overall_time_dell.get(i)/10,2,2);
            }
            if(i>0) {
                drp.drawLine(x_tmp.get(i - 1), y_null - hash_map_overall_time_dell.get(i - 1) / 10,x_tmp.get(i), y_null - hash_map_overall_time_dell.get(i) / 10);
                drp.fillOval(x_tmp.get(i)-3
                        ,y_null - hash_map_overall_time_dell.get(i)/10-3,6,6);
                drp.fillOval(x_tmp.get(i-1)-3
                        ,y_null - hash_map_overall_time_dell.get(i-1)/10-3,6,6);
            }
        }
    }
}
