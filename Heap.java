import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data=new ArrayList<Integer>(); 
	public void add(int item)
	{
		data.add(item);
		upheapify(data.size()-1);
	}
	
	public void upheapify(int index)
	{
//		if(index==0 && data.get(0)>data.get(index))
//		{
//			swap(0,index);
//			return ;
//		}
//		else {
		
			int parent=(index-1)/2;
			if(parent==0 && index==0)
			{
				return;
			}
			
			if(data.get(parent)>data.get(index))
			{
				swap(parent,index);
				upheapify(parent);
			}
			
			}
			
//		}
	

	private void swap(int i, int index) {
		int a=data.get(i);
		int b=data.get(index);
		
		data.remove(i);
		data.add(i, b);
		
		
		data.remove(index);
		data.add(index, a);

		
		
	}
	
	public void displayHeap() {
		System.out.println(data);
		
	}
	
	
	public int remove() {
		int remove_index=0;
		int x=data.get(remove_index);
		swap(0,data.size()-1);
		data.remove(data.size()-1);
		
		downHeapify(0);
		return x;
	}

	private void downHeapify(int parent) {
		System.out.println("pppp"+parent);
		int child1=(2*parent)+1;
		int child2=(2*parent)+2;
		if((child1>data.size()-1)&&(child2>data.size()-1))
		{
			return;
		}
		System.out.println(child1+""+child2);
		int min_index=findMinIndex(parent,child1,child2);
		System.out.println(min_index);
		swap(min_index,parent);
		downHeapify(min_index);
		
		
		
	}

	private int findMinIndex(int parent, int child1, int child2) {
		int x=Integer.min(data.get(child1),data.get(child2));
		int y=Integer.min(x, data.get(parent));
		return data.indexOf(y);
	}

}
