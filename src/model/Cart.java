package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable{
     
	private static final long serialVersionUID = 1L;
	private ArrayList<TShirt> list;
      private double total;
      private int shipment;
      
      public Cart(){
    	  list=new ArrayList<TShirt>();
    	  total=0;
    	  shipment=0;
      }
      public void setShipment(){
    	  int i=0;
    	  for(TShirt x:list){
    		  i=i+x.getquantita();
    	  }
    	  if(i>=3)
    		  shipment=0;
    	  else
    		  shipment=3;
      }
      public void setTotal(){
    	  total=0;
    	  setShipment();
    	  for(TShirt x:list){
    		  total=total+x.getprezzo()*x.getquantita()+shipment*x.getquantita();
    	  }
      }
      public void addItem(TShirt p){
    	  int i=0;
    	  if(list.isEmpty())
    		  list.add(p);
    	  else{
    	  for(TShirt x:list){
    		  if(p.equals(x)){
    			  int f=x.getquantita();
    			  x.setquantita(f+p.getquantita());
    			  i++;
    			  break;
    		  }
    	  }
    	  if(i==0){
    		  list.add(p);
    	  }
    	  }
    	  setTotal();
      }
      public void deleteItem(int id,String sesso,String colore,String taglia){
    	  for(TShirt x:list){
    		  if(x.getidArticolo()==id&&x.getSesso().equalsIgnoreCase(sesso)&&x.getColore().equalsIgnoreCase(colore)&&x.getTaglia().equalsIgnoreCase(taglia)){
    			  list.remove(x);
    			  break;
    		  }
    	  }
    	  setTotal();
      }
      public void modifyT(int id,String sesso,String tg,String col,String tg1){
    	  for(TShirt x:list){
    		  if(x.getidArticolo()==id&&x.getSesso().equalsIgnoreCase(sesso)&&x.getColore().equalsIgnoreCase(col)&&x.getTaglia().equalsIgnoreCase(tg1)){
    			  x.setTaglia(tg);
    			  tg1=tg;
    			  break;
    		  }
    	  }
    	  int c=0,q=0;
    	  for(TShirt x:list){
    		  if(x.getidArticolo()==id&&x.getSesso().equalsIgnoreCase(sesso)&&x.getColore().equalsIgnoreCase(col)&&x.getTaglia().equalsIgnoreCase(tg)&&c==0){
    			 c=1;
    			 q=x.getquantita();
    		  }
    		  else if(x.getidArticolo()==id&&x.getSesso().equalsIgnoreCase(sesso)&&x.getColore().equalsIgnoreCase(col)&&x.getTaglia().equalsIgnoreCase(tg)&&c==1){
    			  x.setquantita(x.getquantita()+q);
    			  deleteItem(id, sesso, col, tg);
    			  break;
    		  }
    	  }
      }
      public void modifyQ(int id,String sesso,int q,String col,String tg){
    	  for(TShirt x:list){
    		  if(x.getidArticolo()==id&&x.getSesso().equalsIgnoreCase(sesso)&&x.getColore().equalsIgnoreCase(col)&&x.getTaglia().equalsIgnoreCase(tg)){
    			  x.setquantita(q);
    		  }
    	  }
    	  setTotal();
      }
      public void delete(){
    	  list=new ArrayList<TShirt>();
    	  setTotal();
      }
      public ArrayList<TShirt> getProducts(){
    	  return list;
      }
      public double getTotal(){
    	  return total;
      }
      public int getShipment(){
    	  return shipment;
      }
      public String getShipmentString(){
    	  if(shipment==0)
    		  return "Gratis!";
    	  else
    		  return (shipment*list.size())+",00 €";
      }
      public int totalItem(){
    	  int i=0;
    	  for(TShirt x:list){
    		  i=i+x.getquantita();
    	  }
    	  return i;
      }
}
