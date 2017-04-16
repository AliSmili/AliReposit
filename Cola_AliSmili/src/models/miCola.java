package models;

public class miCola<T> implements Cola<T> {

	 private T[] arr;
	 private int total ;																	//Tamaño del array despues de redimensionarlo
	 private int top;

	    @SuppressWarnings("unchecked")
		public miCola()
	    {
	    	this.total = 0;
	        arr = (T[]) new Object[total];
	        top = -1;
	    }

	    @SuppressWarnings("unused")
		private void resize(int capacidad)
	    {
	        total = capacidad;
			@SuppressWarnings("unchecked")
			T[] tmp = (T[]) new Object[total];
	        System.arraycopy(arr, 0, tmp, 0, total);									//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	        arr = tmp;
	    }
	    
	     @SuppressWarnings("unchecked")
		public void push(T ele)
	    {       	    	 
	    	 if(total == 0){
	    	 total = 1;
	    	 arr = (T[]) new Object[total];
	    	 }
	    	   if(top==total-1 || arr[total-1] != null){
		           System.out.println("La Cola se ha redimensionado y se introdujo el nuevo elemento ! ");
	    		   total = total+1;
	    		   T[] tmp = (T[]) new Object[total];
	    		   //System.arraycopy(arr, 0, tmp, 0, total);								// Me da Error , no se pq?  public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	    		   for(int i=0; i<arr.length;i++){											//A la vieja ausansa
	    			   tmp[i]=arr[i];
	    		   }
	    		   arr = tmp;
	    		   arr[++top] = ele;
	    		 
		            
		       }else{
	    		arr[++top] = ele;
		       }
	      
	    }
	     
	     public T pop(){
	    	 T elem = arr[arr.length-1];
	    	 if(!isEmpty()){	 
		    	  System.out.println("Se ha quitado de la Cola este elmento : "+elem); 
		    	  arr[arr.length-1]= null;														//Establecemos la ultima posicion del array a null despues del desplazamiento
				  total= total - 1;															    //Redimensionamos nuestro Array una posición menos
				  @SuppressWarnings("unchecked")
				  T[] tmp = (T[]) new Object[total];
				  System.arraycopy(arr, 0, tmp, 0, total);								        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
					       arr = tmp;
					      
	    	 }else{
	    		 
	    		 elem = null;
	    	 }
	    	 return  elem;	    	 
	     }
	     

	   /* public void pop()																	//Dejo este código comentado ya que con el void es factíble también
	    {
	    	if(!isEmpty()){
	             
	    	  System.out.println("Se ha quitado de la Cola este elmento : "+arr[arr.length-1]); 
	    	  
	    	  arr[arr.length-1]= null;														//Establecemos la ultima posicion del array a null despues del desplazamiento
			  total= total - 1;															    //Redimensionamos nuestro Array una posición menos
			  @SuppressWarnings("unchecked")
			  T[] tmp = (T[]) new Object[total];
			  System.arraycopy(arr, 0, tmp, 0, total);								        //public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
				       arr = tmp;
	    	  	       
	    	  }else{
	    	
	    		  System.out.println("No hay ningún elemento en la Cola ! ");
	    	  }
	    }*/
	    	    
	    public void remove (T element){
	    	  
	    	  int contador = 0;
	    	 
	    	  for(int i = 0; i<arr.length; i++){
	    		  
	    		  if(element.equals(arr[i]) ){
	    			  for(int j=i; j<(arr.length-1); j++)
	                  {
	                      arr[j] = arr[j+1];								//Desplazamiento a la izquierda sustituyendo el elemento que queremos quitar por el siguiente
	                  }
	    			  									
	    			  contador ++;
	    			  break;
	    			  
	    		  }
	    	  }
	    		 if(contador ==0){
	    			 System.out.println("Elemento no encontrado ");
	    		 }
	    		 else{	    			 	
	    				 arr[arr.length-1]= null;							//Establecemos la ultima posicion del array a null despues del desplazamiento
	    				 total= total - 1;									//Redimensionamos nuestro Array una posición menos
	    					@SuppressWarnings("unchecked")
							T[] tmp = (T[]) new Object[total];
	    				     System.arraycopy(arr, 0, tmp, 0, total);		//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	    				       arr = tmp;
	    		 }
	    		  
	    	  }
	    
	    @SuppressWarnings("unchecked")
		public void clear(){
	    	 arr = (T[]) new Object[0];
	    }
	    
	    public boolean contains(T v){
	    	
	        for ( T e : arr)
	            if (e == v || v != null && v.equals(e))
	                return true;

	        return false;
	    }
	    
	    public boolean isEmpty() {
	       
	    	
	    	return top == -1;
	     }
	    
	    public int size(){
	    	
	    	return total;
	    }
	    
	    public void display(){

	        for(int i=0;i<arr.length;i++){
	            System.out.print(arr[i]+ " ");
	        }
	        System.out.println();
	    }
	    
	    @Override
	    public String toString()
	    {
	      //return java.util.Arrays.toString(arr);
	    	return arr.toString();
	    }

	}
