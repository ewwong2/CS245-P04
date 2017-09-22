
public class ArrayStack implements Stack {
	private Object[] as;
	private int top;
	
	public ArrayStack() {
		as = new Object[10];
		top = 0;
	}
	
	@Override
	public void push(Object item) {
		if (top==as.length) {
			growstack();
		}
		as[top++] = item;
	}

	private void growstack() {
		Object[] temp = new Object[as.length*2];
		System.arraycopy(as, 0, temp, 0, as.length);
		as = temp;
	}

	@Override
	public Object pop() {
		if (empty()) {
			return null;
		}
		top--;
		return as[top];
	}

	@Override
	public Object peek() {
		if (empty()) {
			return null;
		}
		return as[top];
	}

	@Override
	public boolean empty() {
		if (top==0) {
			return true;
		}
		return false;
	}

}
