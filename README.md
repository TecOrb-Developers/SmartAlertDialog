# SmartAlertDialog 
With this library you can easily use alert dialog in Android.<br>
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
                        .setTitle("Smart Dialog")
                        .setSubTitle("This is the alert dialog to showing alert to user")
                        .setCancalable(false)
                        .setTitleFont(titleFont) //set title font
                        .setSubTitleFont(subTitleFont) //set sub title font
                        .setNegativeButtonHide(true) //hide cancel button
                        .setPositiveButton("OK", new SmartDialogClickListener() {
                            @Override
                            public void onClick(SmartDialog smartDialog) {
                                Toast.makeText(context,"Ok button Click",Toast.LENGTH_SHORT).show();
                                    smartDialog.dismiss();
                            }
                        }).setNegativeButton("Cancel", new SmartDialogClickListener() {
                    @Override
                    public void onClick(SmartDialog smartDialog) {
                        Toast.makeText(context,"Cancel button Click",Toast.LENGTH_SHORT).show();
                        smartDialog.dismiss();

                    }
                }).build().show();
	
	
If you liked this library, add a star to this project and feel free to make a <b>fork!</b><br>
<br><br>
