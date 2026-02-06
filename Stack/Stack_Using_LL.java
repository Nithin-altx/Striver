class Node{
    int val;
    Node next;
    Node(int val)
    {
        this.val=val;
    }
}
class Stack1{
    Node top;int size=0;
    void push(int x)
    {
        Node temp=new Node(x);
        temp.next=top;
        top=temp;
        size++;
    }
    void pop()
    {
        if(top==null)
        System.out.println("no elements");
        else{
        top=top.next;
        size--;
        }
    }
    void Size()
    {
       System.out.println(size);
    }
    void top()
    {
        System.out.println(top.val);
    }
    void print()
    {
        Node temp=top;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
}
public class Stack_Using_LL{
    public static void main(String[] args) {
        Stack1 s=new Stack1();
        s.push(5);
        s.push(6);
        s.push(7);
        s.top();
        s.Size(); 
    }   
}
