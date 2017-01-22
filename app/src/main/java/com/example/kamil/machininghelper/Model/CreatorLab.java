package com.example.kamil.machininghelper.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CreatorLab {

    private Context mContext;
    private static CreatorLab sCreatorLab;
    private List<Material> mSteelMillingMaterials;
    private List<Material> mCarbideMillingMaterials;

    private CreatorLab(Context context) {
        mContext = context;

        mCarbideMillingMaterials = new ArrayList<>();
        mCarbideMillingMaterials.add(new Material("Low carbon unalloyed steel", 137, 198, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Medium carbon unalloyed steel", 122, 191, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("High carbon unalloyed steel", 99, 152, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Normal condition low alloy steel", 122, 168, 0.102, 0.152));
        mCarbideMillingMaterials.add(new Material("Heat threated to 32 Rc low alloy steel", 76, 114, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Normal condition high alloy steel", 107, 145, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Heat threated to 32 Rc high alloy steel", 61, 84, 0.038, 0.089));
        mCarbideMillingMaterials.add(new Material("Ferritic/martensitic stainless steel", 76, 107, 0.038, 0.089));
        mCarbideMillingMaterials.add(new Material("Austenic stainless steel I", 91, 168, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Austenic stainless steel II", 84, 160, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Austenitic precip. hardened stainless", 76, 152, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Iron based heat resistant alloy", 30, 61, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Nickel based heat resistant alloy", 21, 46, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Cobalt based heat resistant alloy", 18, 34, 0.038, 0.102));
        mCarbideMillingMaterials.add(new Material("Titanium heat resistant alloy", 30, 40, 0.051, 0.102));
        mCarbideMillingMaterials.add(new Material("Gray class 20 cast iron", 122, 198, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Gray class 30, class 40 cast iron", 107, 168, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Nodular cast iron", 107, 152, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Aluminium alloy", 457, 732, 0.102, 0.203));
        mCarbideMillingMaterials.add(new Material("Brass - bronze alloy", 244, 457, 0.076, 0.152));
        mCarbideMillingMaterials.add(new Material("Hi-velocity machining aluminium alloy", 1524, 5486, 0.102, 0.203));

        mSteelMillingMaterials = new ArrayList<>();
        mSteelMillingMaterials.add(new Material("Low carbon unalloyed steel", 18, 34, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Medium carbon unalloyed steel", 12, 30, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("High carbon unalloyed steel", 9, 26, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Normal condition low alloy steel", 12, 24, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Heat threated to 32 Rc low alloy steel", 11, 18, 0.064, 0.127));
        mSteelMillingMaterials.add(new Material("Normal condition high alloy steel", 11, 23, 0.064, 0.127));
        mSteelMillingMaterials.add(new Material("Heat threated to 32 Rc high alloy steel", 9, 18, 0.051, 0.102));
        mSteelMillingMaterials.add(new Material("Ferritic/martensitic stainless steel", 6, 17, 0.051, 0.127));
        mSteelMillingMaterials.add(new Material("Austenic stainless steel I", 9, 18, 0.076, 0.178));
        mSteelMillingMaterials.add(new Material("Austenic stainless steel II", 8, 17, 0.076, 0.178));
        mSteelMillingMaterials.add(new Material("Austenitic precip. hardened stainless", 6, 15, 0.076, 0.178));
        mSteelMillingMaterials.add(new Material("Iron based heat resistant alloy", 9, 18, 0.051, 0.102));
        mSteelMillingMaterials.add(new Material("Nickel based heat resistant alloy", 8, 15, 0.051, 0.102));
        mSteelMillingMaterials.add(new Material("Cobalt based heat resistant alloy", 5, 9, 0.051, 0.114));
        mSteelMillingMaterials.add(new Material("Titanium heat resistant alloy", 8, 15, 0.064, 0.114));
        mSteelMillingMaterials.add(new Material("Gray class 20 cast iron", 18, 34, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Gray class 30, class 40 cast iron", 15, 29, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Nodular cast iron", 21, 34, 0.102, 0.203));
        mSteelMillingMaterials.add(new Material("Aluminium alloy", 183, 274, 0.127, 0.229));
        mSteelMillingMaterials.add(new Material("Brass - bronze alloy", 76, 91, 0.102, 0.203));
    }

    public static CreatorLab getCreatorLab(Context context){
        if (sCreatorLab == null)
            sCreatorLab = new CreatorLab(context.getApplicationContext());

        return sCreatorLab;
    }

    public List<Material> getSteelMillingMaterials() {
        return mSteelMillingMaterials;
    }

    public List<Material> getCarbideMillingMaterials() {
        return mCarbideMillingMaterials;
    }
}
