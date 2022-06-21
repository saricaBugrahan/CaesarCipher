public class Caesar {
    private int shifting;//How many char
    private boolean encryption;//For encrpytion or decryption choice
    private String plaintext;
    private String ciphertext;
    private char[] lettersOfPlaintext;
    private char[] lettersOfCiphertext;

    public Caesar(String text,int shifting,boolean encryption)
    {
        this.shifting = shifting;
        if(encryption)
        {
            this.plaintext = text;
            lettersOfPlaintext = this.plaintext.toCharArray();
            lettersOfCiphertext = new char[lettersOfPlaintext.length];
        }
        else
        {
            this.ciphertext = text;
            lettersOfCiphertext = this.ciphertext.toCharArray();
            lettersOfPlaintext = new char[lettersOfCiphertext.length];
        }
    }
    public void encryption(){
        for(int i = 0;i< lettersOfPlaintext.length;i++)
        {
            if(lettersOfPlaintext[i]>=65 && lettersOfPlaintext[i]<=90)//Lowercase letters in ASCII Table
            {
                int newPos = lettersOfPlaintext[i]+shifting;
                while(newPos>90)// If there is any overflow
                {
                    newPos = newPos-26;
                }
                lettersOfCiphertext[i] = (char)newPos;
            }
            else if(lettersOfPlaintext[i]>=97 && lettersOfPlaintext[i]<=122)//Uppercase letters in ASCII Table
            {
                int newPos = lettersOfPlaintext[i]+shifting;
                while (newPos>122)//If there is any overflow
                {
                    newPos = newPos-26;
                }
                lettersOfCiphertext[i] = (char)newPos;
            }
            else
            {
                System.out.println("Invalid type of character");//Give error messeage for other characters that is not in the english alphabet
                System.exit(0);
            }
        }
        ciphertext = merge(lettersOfCiphertext);
    }
    public void decryption()
    {
        for(int i = 0;i< lettersOfCiphertext.length;i++)
        {
            if(lettersOfCiphertext[i]>=65 && lettersOfCiphertext[i]<=90)
            {
                int newPos = lettersOfCiphertext[i]-shifting;
                while(newPos<65)
                {
                    newPos = newPos+26;
                }
                lettersOfPlaintext[i] = (char)newPos;
            }
            else if(lettersOfCiphertext[i]>=97 && lettersOfCiphertext[i]<=122)
            {
                int newPos = lettersOfCiphertext[i]-shifting;
                while(newPos<97)
                {
                    newPos = newPos+26;
                }
                lettersOfPlaintext[i] = (char)newPos;
            }
            else
            {
                System.out.println("Invalid type of charachter");
                System.exit(0);
            }
        }
       plaintext =  merge(lettersOfPlaintext);
    }
    private String merge(char[] arr)
    {
        StringBuilder s = new StringBuilder(lettersOfCiphertext.length);//StringBuilder for proper concatenation.
        for(int i = 0;i< arr.length;i++)
        {
            s.append(arr[i]);
        }
        return s.toString();
    }
    public String getCiphertext()
    {
        return ciphertext;
    }
    public String getPlaintext()
    {
        return plaintext;
    }
}
