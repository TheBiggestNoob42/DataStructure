
public class DNA
{
    float fitness;
    static String target;
    char[] genes;
    static double mutationRate = 0.01;


    public DNA()
    {

        genes = new char[target.length()];
        for(int i = 0; i < genes.length; i++)
        {
            genes[i] = (char) (Math.random() * 96 + 32);
        }
    }

    public void fitness()
    {
        int score = 0;
        for(int i = 0; i < genes.length; i++)
        {
            if(genes[i] == target.charAt(i))
                score++;
        }

        fitness = (float) score / ( 1.0f * genes.length);
    }

    public void mutate()
    {
        for(int i = 0; i < genes.length; i++)
        {
            double chance = Math.random();
            if(chance < mutationRate)
            {
                genes[i] = (char) (Math.random() * 96 + 32);
            }

        }
    }

    public DNA crossover(DNA parent)
    {
        DNA child = new DNA();

        int midPoint = (int)(Math.random() * genes.length);

        for(int i = 0; i < genes.length; i++)
        {
            if(i < midPoint)
                child.genes[i] = genes[i];
            else
                child.genes[i] = (parent).genes[i];
        }

        return child;
    }
}
