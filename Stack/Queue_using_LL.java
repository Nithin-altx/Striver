class Node{
    int val;
    Node next;
    Node(int val)
    {
        this.val=val;
    }
}
class Queue{
    Node start,end;int size=0;
    void push(int x)
    {
        Node temp=new Node(x);
        if(start==null)
        {
            start=end=temp;
        }
        else{
            end.next=temp;
            end=end.next;
        }
        size++;
    }
    void pop()
    {
        if(start==null||end==null)
        {
            start=end=null;
            System.out.println("No bro");
        }
        else{
            start=start.next;
            size--;
        }
    }
    void top()
    {
        System.out.println(start.val);
    }
    void Size()
    {
        System.out.println(size);
    }
    void print()
    {
        Node temp=start;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
public class Queue_using_LL{
    public static void main(String[] args) {
        Queue q=new Queue();
        q.push(2);
        q.push(4);
        q.push(5);
        q.pop();
        q.pop();
        q.pop();
        q.pop();
        q.push(2);
        q.push(4);
        q.push(5);
        q.print();
        q.Size();
        q.top();
        
    }
    
}
