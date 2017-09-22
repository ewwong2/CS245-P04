
public class ArrayQueue implements Queue {
	private Object[] aq;
	private int head;
	private int tail;
	
	public ArrayQueue() {
		aq = new Object[10];
		head = 0;
		tail = 0;
	}
	
	@Override
	public Object dequeue() {
		if (empty()) {
			return null;
		}
		int temp = head;
		head = (head+1)%aq.length;
		return aq[temp];
	}

	@Override
	public void enqueue(Object item) {
		if (full()) {
			growqueue();
		}
		aq[tail] = item; 
		tail = (tail+1)%aq.length;
	}

	private boolean full() {
		if ((tail+1)%aq.length == head) {
			return true;
		}
		return false;
	}

	private void growqueue() {
		Object[] temp = new Object[aq.length*2];
		for (int i = 0; i<aq.length-1; i++) {
			temp[i] = aq[(head+i)%aq.length];
		}
		head = 0;
		tail = aq.length-1;
		aq = temp;
	}

	@Override
	public boolean empty() {
		if (head == tail) {
			return true;
		}
		return false;
	}

}
