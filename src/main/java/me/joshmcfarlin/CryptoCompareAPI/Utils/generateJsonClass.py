def format_collection(collection):
    for line in collection.splitlines():
        if len(line) != 0:
            var_type, var_name = line.rsplit(' ', 1)
            var_name = var_name.replace(';', '')
            print("/**\n *\n */")
            print("@SerializedName(\"" + var_name + "\")")
            print(var_type + ' ' + var_name[0].lower() + var_name[1:] + ';')
        else:
            print()


coll = """
public String Description;
public String Features;
public String Technology;
public Double TotalCoinSupply;
public String Algorithm;
public String ProofType;
public String StartDate;
public String Twitter;
public String AffiliateUrl;
public String Website;
public Sponsor sponsor;
public int LastBlockExplorerUpdateTS;
public String DifficultyAdjustment;
public String BlockRewardReduction;
public int BlockNumber;
public double BlockTime;
public double NetHashesPerSecond;
public double TotalCoinsMined;
public double PreviousTotalCoinsMined;
public double BlockReward;

public String TextTop;
public String Link;
public String ImageUrl;
"""

format_collection(coll)