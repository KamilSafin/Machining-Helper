package com.example.kamil.machininghelper.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class CreatorLab {

    private Context mContext;
    private static CreatorLab sCreatorLab;
    private List<Material> mSteelMillingMaterials;
    private List<Material> mCarbideMillingMaterials;
    private List<TurningMaterial> mTurningMaterials;

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

        mTurningMaterials = new ArrayList<>();
        mTurningMaterials.add(new TurningMaterial("Mild Steel", CuttingType.LIGHT, 0d, 1d, 0d, null, 0.3d, 235d, 290d, 335d, 1));
        mTurningMaterials.add(new TurningMaterial("Mild Steel", CuttingType.MEDIUM, 1d, 6d, 0.2d, 0.4d, 0.6d, 260d, 350d, 440d, 1));
        mTurningMaterials.add(new TurningMaterial("Mild Steel", CuttingType.SEMI_HEAVY, 4d, 9d, 0.5d, 0.6d, 0.8d, 260d, 350d, 440d, 1));
        mTurningMaterials.add(new TurningMaterial("Carbon Steel", CuttingType.LIGHT, 0d, 1d, 0d, null, 0.3d, 210d, 280d, 355d, 2));
        mTurningMaterials.add(new TurningMaterial("Carbon Steel", CuttingType.MEDIUM, 1d, 6d, 0.2d, 0.4d, 0.6d, 190d, 260d, 325d, 2));
        mTurningMaterials.add(new TurningMaterial("Carbon Steel", CuttingType.SEMI_HEAVY, 4d, 9d, 0.5d, 0.6d, 0.8d, 180d, 250d, 310d, 2));
        mTurningMaterials.add(new TurningMaterial("Alloy Steel", CuttingType.LIGHT, 0d, 1d, 0d, null, 0.3d, 120d, 180d, 230d, 3));
        mTurningMaterials.add(new TurningMaterial("Alloy Steel", CuttingType.MEDIUM, 1d, 4d, 0.2d, 0.3d, 0.4d, 120d, 170d, 210d, 3));
        mTurningMaterials.add(new TurningMaterial("Austenic Stainless Steel", CuttingType.LIGHT, 0d, 1d, 0d, null, 0.2d, 95d, 140d, 185d, 4));
        mTurningMaterials.add(new TurningMaterial("Austenic Stainless Steel", CuttingType.MEDIUM, 1d, 4d, 0.2d, 0.3d, 0.4d, 85d, 120d, 155d, 4));
        mTurningMaterials.add(new TurningMaterial("High Manganese Steel", null, 1d, 4d, 0.1d, 0.2d, 0.4d, 120d, 170d, 210d));
        mTurningMaterials.add(new TurningMaterial("Pure Titamium", null, 0.5d, 1.5d, 0.1d, 0.15d, 0.2d, 80d, 100d, 120d));
        mTurningMaterials.add(new TurningMaterial("Titamium Alloy", null, 0.5d, 1.5d, 0.1d, 0.15d, 0.2d, 40d, 70d, 90d));
        mTurningMaterials.add(new TurningMaterial("Nickel Base Alloy", null, 0.5d, 1.5d, 0.1d, 0.15d, 0.2d, 20d, 40d, 50d));
        mTurningMaterials.add(new TurningMaterial("Stellite", null, 0.5d, 1.5d, 0.1d, 0.15d, 0.2d, 20d, 30d, 40d));
        mTurningMaterials.add(new TurningMaterial("Die Steel", null, 1d, 4d, 0.2d, 0.3d, 0.4d, 150d, 210d, 260d));
        mTurningMaterials.add(new TurningMaterial("High Speed Steel", null, 0d, 0.5d, 0.1d, 0.2d, 0.3d, 80d, 200d, 250d));
        mTurningMaterials.add(new TurningMaterial("Gray Cast Iron", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 160d, 230d, 295d));
        mTurningMaterials.add(new TurningMaterial("Ductile", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 160d, 200d, 295d));
        mTurningMaterials.add(new TurningMaterial("Cast Iron", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 100d, 150d, 200d));
        mTurningMaterials.add(new TurningMaterial("Malleable Iron", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 100d, 150d, 200d));
        mTurningMaterials.add(new TurningMaterial("Chilled Cast Iron", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 100d, 150d, 200d));
        mTurningMaterials.add(new TurningMaterial("Aluminium Alloy", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 200d, 400d, 600d));
        mTurningMaterials.add(new TurningMaterial("Copper Alloy", null, 1d, 6d, 0.2d, 0.4d, 0.6d, 150d, 230d, 300d));
        mTurningMaterials.add(new TurningMaterial("Sintered Alloy Steel", null, 1d, 4d, 0.1d, 0.2d, 0.3d, 150d, 200d, 250d));
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

    public List<TurningMaterial> getTurningMaterials() {
        return mTurningMaterials;
    }
}
