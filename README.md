# SmartAlertDialog 
With this library you can easily use alert dialog in Android.<br>

Made changes for : 
- Remove default icon and add custom icon 
- Long Contents can be scrollable
- Can change title and sub title color
- Can change the Fort

Methods Used for:
- setTitle()              //String 
- setSubTitle()           //String
- setCancalable()         //boolean
- setCustomIcon()         //drawable 
- setTitleColor()         //Color
- setSubTitleColor()      //Color
- setTitleFont()          //Typeface
- setSubTitleFont()       //Typeface
- setNegativeButtonHide() //boolean 
- useNeutralButton()      //boolean 
- setPositiveButton()     
- setNeutralButton()
- setNeutralButton()


<table>
<tr>
<td><img src="http://res.cloudinary.com/duyx74vfd/image/upload/v1528460761/1528459502779_vuomau.jpg" width=250><br>With Two Buttons</td>
<td><img src="http://res.cloudinary.com/duyx74vfd/image/upload/v1528460761/1528459502635_ojwj6u.jpg" width=250><br>With One Button</td>
</tr>
</table>
<br>
To install the library just add this line to your gradle:
	
	implementation 'com.github.TecOrb-Developers:SmartAlertDialog:v1.0'
	
And add this where you want:

           new SmartDialogBuilder(context)
	        .setTitle(getString(R.string.txt_smart_dialog))
                .setSubTitle(getString(R.string.txt_alert))
                .setCancalable(false)
                .setCustomIcon(R.drawable.icon)
                .setTitleColor(getResources().getColor(R.color.colorPrimaryDark))
                .setSubTitleColor(getResources().getColor(R.color.colorPrimaryDark))
                .setTitleFont(tfBold)
                .setSubTitleFont(tfRegular)
                .setNegativeButtonHide(false)
                .useNeutralButton(true)
                .setPositiveButton(getString(R.string.txt_ok), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();
                    }
                })
                .setNegativeButton(getString(R.string.txt_cancel), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();

                    }
                })
                .setNeutralButton(getString(R.string.txt_later), new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        smartDialog.dismiss();
                    }
                })
                .build().show();
	
	
If you liked this library, add a star to this project and feel free to make a <b>fork!</b><br>
<br><br>
