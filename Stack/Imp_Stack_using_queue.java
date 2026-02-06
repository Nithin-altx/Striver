import java.util.LinkedList;
import java.util.Queue;


class SQ{
    Queue<Integer> pq=new LinkedList<>();
    void push(int x)
    {
        int s=pq.size();
        pq.offer(x);
        for(int i=1;i<=s;i++)
        {
            pq.offer(pq.peek());
            pq.poll();
        }
    }
    void pop()
    {
        pq.poll();
    }
   void print() {
        for (Integer v : pq) {
            System.out.println(v);
        }
    }
}
public class Imp_Stack_using_queue {

    public static void main(String[] args) {
        SQ sq=new SQ();
        sq.push(4);
        sq.push(5);
        sq.push(6);
        sq.print();
        sq.pop();
        sq.print();
        
    }
    
}
