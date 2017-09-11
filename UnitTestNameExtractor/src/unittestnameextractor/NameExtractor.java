/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestnameextractor;

/**
 *
 * @author bigmanlaptop
 */

import java.util.Arrays;
import com.google.common.base.Splitter;

public class NameExtractor {
        public static void main(String[] args)
    {
        NameExtractor obj = new NameExtractor();
        
        obj.setFullName(" Mr. John Brown");
        System.out.println(obj.getTitle());
        System.out.println(obj.getFirstName());
        System.out.println(obj.getMiddleName());
        System.out.println(obj.getLastName());
        System.out.println(obj.getSuffix());
    }
    //Private Members
    private String mFullName; //full name
    private String mTitle;
    private String mFirstName;
    private String mMiddleName;
    private String mLastName;
    private String mSuffix;
    private String[] mWords; //array of the words obtained from the mFullName
    private int mNumWords; //the number of words in the mFullName
    private final String[] TitleList = { "Mr.", "Mr", "Ms.", "Ms", "Miss.", "Miss", "Dr.", "Dr", "Mrs.", "Mrs", "Fr.", "Capt.", "Lt.", "Gen.", "President", "Sister", "Brother", "Father", "Major" };
    private final String[] SuffList = { "DDS", "CFA", "CEO", "CFO", "Esq", "CPA", "MBA", "PhD", "MD", "DC", "Sr", "Jr", "II", "III", "IV" };
    
    
    //protected members
    protected  void ExtractWords(String Value)
    {
        char[] separators = { ' ', ',', '.', ':', '\t' };
        String[] words;
        
        String regex ="(" + new String(separators).replaceAll("(.)", "\\\\$1|").replaceAll("\\|$", ")");
        words = Value.split(regex);
        String[] words1 = new String[5];
        
        //exclude empty words (if any)
        int i = 0;
        int k = 0;
        
        while((i <= words.length -1) && (k <= 4))
        {
            {
                if("".equals(words[i]))
                {
                    i++;
                    continue;
                }
                words1[k] = words[i];
                mNumWords = k+1;
                k++;
                i++;
            }
        }
        
        mWords = words1;
        
    }
    
    protected void ParseName()
    {
        //intital values
        mTitle = "";
        mFirstName = "";
        mMiddleName = "";
        mLastName = "";
        mSuffix = "";
        
        //finding words
        if((mFullName != null) && (!"".equals(mFullName)))
        {
            ExtractWords(mFullName);
            FindTitle();
            Findsuffix();
            FindLastName();
            FindFirstName();
            FindMiddleName();
        }
    }
    
    protected int FindTitle()
    {
        //0 - the title might be the first word only
        if(mWords != null)
        {
            if(Arrays.asList(TitleList).contains(mWords[0]))
            {
                mTitle = mWords[0];
                return 0;
            }
            else
            {
                return -1; // no title
            }
        }
        return -1;
    }
    
    protected int Findsuffix()
    {
        if(mWords[4] != null)
        {
            mSuffix = mWords[4];
            return 0;
        }
        else
        {
            
            if(( mWords[4] != null) && (Arrays.asList(SuffList).contains(mWords[2])))
           {
                mSuffix = mWords[2];
                return 0;
            }
            if(( mWords[3] != null) && (Arrays.asList(SuffList).contains(mWords[3])))
            {
                mSuffix = mWords[3];
                return 0;
            }
        }
        return -1;
    }
    
    protected int FindFirstName()
    {
        if((mNumWords >= 2) && ("".equals(mTitle)))
        {
            mFirstName = mWords[0];
            return 0;
        }
        if((mNumWords > 2) && (!"".equals(mTitle)))
        {
            mFirstName = mWords[1];
            return 0;
        }
        if(mNumWords == 5)
        {
            mFirstName = mWords[1];
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    
    protected int FindMiddleName()
    {
        if((mNumWords == 5) || ((mNumWords == 4) && ("".equals(mSuffix))))
        {
           mMiddleName = mWords[2];
           return 0;
        }
        if(((mNumWords == 4) && ("".equals(mTitle)) ) || ((mNumWords == 4) && ("".equals(mSuffix))))
        {
            mMiddleName = mWords[1];
            return 0;
        }
        if((mNumWords == 3) && ("".equals(mSuffix)) && ("".equals(mTitle)))
        {
            mMiddleName = mWords[1];
        }
        return -1;
    }
    
    protected int FindLastName()
    {
        if(mNumWords == 1)
        {
            mLastName = mWords[0];
            return 0;
        }
        if(mNumWords == 2)
        {
            mLastName = mWords[1];
            return 0;
        }
        if(mNumWords == 5)
        {
            mLastName = mWords[3];
            return 0;
        }
        if(((mNumWords ==3) && ("".equals(mSuffix))) ||(mNumWords == 4) && (!"".equals(mSuffix)))
        {
            mLastName = mWords[2];
            return 0;
        }
        else
        {
            if(mNumWords == 3)
            {
                mLastName = mWords[1];
            }
            else
            {
                if(mNumWords ==4)
                {
                    mLastName = mWords[3];
                }
            }
            return 0;
        }
      //  return -1;
    }
        
    
    
    //Public members
    public NameExtractor()
    {
            
    }
        
    public void setFullName(String name)
    {
        mFullName = name;
    }
    
    public String getFullName()
    {
        return mFullName;
    }
    
    public String getTitle()
    {
        return mTitle;
    }
    
    public String getFirstName()
    {
        return mFirstName;
    }
    
    public String getMiddleName()
    {
        return mMiddleName;
    }
    
    public String getLastName()
    {
        return mLastName;
    }
    
    public String getSuffix()
    {
        return mSuffix;
    }
}

class ENameExtractorError extends Exception
{
    public ENameExtractorError(String Message)
    {
        
    }
}
