
public class miCola<T> implements Cola<T> {

	 private T[] arr;

	 private int total;																	//Tamaño del array despues de redimensionarlo

	    public miCola()
	    {
	        arr = (T[]) new Object[0];
	    }

	    private void resize(int capacidad)
	    {
	        T[] tmp = (T[]) new Object[capacidad];
	        System.arraycopy(arr, 0, tmp, 0, total);									//public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	        arr = tmp;
	    }

	    public miCola<T> push(T ele)
	    {
	        if (arr.length == total) resize(arr.length * 2);
	        arr[total++] = ele;
	        return this;
	    }

	    public T pop()
	    {
	        if (total == 0) throw new java.util.NoSuchElementException();					//Se lanza una excepción al encontrarse con un array de capacidad/tamaño 0;
	        T ele = arr[--total];
	        arr[total] = null;
	        if (total > 0 && total == arr.length / 4) resize(arr.length / 2);				//Para optimizar el uso de la memoria y reducir el tamaño del Array 
	        return ele;
	    }
	    
	    public void remove (T element){
	    	  
	    	  int contador = 0;
	    	 
	    	  for(int i = 0; i<arr.length; i++){
	    		  
	    		  if(element == arr[i]){
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
	    				 
	    			 
	    		 }
	    		  
	    	  }
	    
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
	       
	    	for ( T e : arr)
	            if (e == null)
	                return true;
	    	return false;
	     }
	    
	    public int size(){
	    	
	    	return total;
	    }
	    

	    @Override
	    public String toString()
	    {
	      //return java.util.Arrays.toString(arr);
	    	return arr.toString();
	    }

	}
