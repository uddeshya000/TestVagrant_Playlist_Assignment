import java.util.*;
class Playlist
{
    // head pointer- denoting intial song
    Song head=null;

    // tail pointer - denoting last song
    Song tail=null;

    // capacity of playlist
    int capacityofPlaylist=0;

    //counter for counting the no of songs in playlist
    int countsongs=0;


    public Playlist(int capacityofPlaylist)             // constructor of Playlist class
    {
        this.head=null;
        this.tail=null;
        this.countsongs=0;
        this.capacityofPlaylist=capacityofPlaylist;
    }


    public void deleteLeastRecentSong()
    {
        if(head==null)
        {
            return;
        }

        head=head.next;

        countsongs= countsongs-1;
    }

    public void addSong(String songName)
    {
        Song tempSong=new Song(songName);

        if(tail==null)
        {
            head=tempSong;
            tail=tempSong;
        }

        else
        {
            tail.next=tempSong;
            tail=tempSong;
        }

        countsongs=countsongs+1;

        if(countsongs > capacityofPlaylist)
        {
            deleteLeastRecentSong();
        }
    }

    public void displayPlaylist()
    {
        Song temp=head;
        
        System.out.println("Playlist:  ");
        while(temp!=null)
        {
            System.out.print(temp.songName+' ');
            temp=temp.next;
        }
        System.out.println(' ');
    }


    public static void main(String []args)
    {
        //scanner object
        Scanner sc= new Scanner(System.in);

        // size of playlist is N  songs for users
        System.out.println("N songs, provide value for N: ");
        int sizeofPlaylist=sc.nextInt();

        // capacity of playlist
        System.out.println("Capacity for playlist provide value:   ");
        int capacityofPlaylist=sc.nextInt();

        sc.nextLine();

        if(sizeofPlaylist < 0)
        {
            System.out.println("Invalid Input values for Size of Playlist!");
        }

        if(capacityofPlaylist < 0)
        {
            System.out.println("Invalid Input values for Capacity of Playlist!");
        }

        else
        {
            if(sizeofPlaylist >= capacityofPlaylist)
            {   
                Playlist object=new Playlist(capacityofPlaylist);

                while(sizeofPlaylist-- >0)
                {
                    System.out.print("New Song name: ");
                    String songNAme=sc.nextLine();
                    object.addSong(songNAme);
                    object.displayPlaylist();
                }
            }
            else
            {
                System.out.println("Capacity of Songs cannot be greater than Playlist length");    
            }
        }
        
        sc.close();
    }

}


class Song
{
    Song next=null;
    String songName;

    public Song(String songg)                            // constructor of Playlist class
    {
        this.songName=songg;
    }
}