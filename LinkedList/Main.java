import java.util.Scanner;
  class Node{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}

 class Main {
    static  Node head=null;
    static Node temp=null;
static void  insertnodes(int ele)
{
    Node newnode=new Node(ele);
    if(head==null)
    {
        head=newnode;
        temp=newnode;
    }
    else{
        temp.next=newnode;
        temp=newnode;
    }
}
static void print()
{
    Node temp=head;
    while(temp!=null)
    {
        System.out.print(temp.data+" ");
        temp=temp.next;
    }
}
static void insertatfirst(int ele)
{
    Node newnode=new Node(ele);
    newnode.next=head;
    head=newnode;
}
static void insertatlast(int ele)
{
    insertnodes(ele);
}
static void insertatposition(int p,int ele)
{
    Node temp=head;
    Node prev=null;
    int i=1;
    while(i<p)
    {
        prev=temp;
        temp=temp.next;
        i++;
    }
    Node newnode=new Node(ele);
    prev.next=newnode;
    newnode.next=temp;
}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        insertnodes(10);
        insertnodes(15);
        insertnodes(20);
        insertnodes(30);
        insertatfirst(9);
        insertatlast(35);
        insertatposition(3,14);
        print();
        System.out.println();


    }
    
}
