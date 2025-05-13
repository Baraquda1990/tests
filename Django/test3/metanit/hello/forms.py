from django import forms

class UserForm(forms.Form):
    name=forms.CharField(label="Name",initial="undefined",help_text="Enter your name")
    age=forms.IntegerField(label="Ages",initial=18,help_text="Enter your age")
    comment=forms.CharField(label="Comment",widget=forms.Textarea)
    field_order=["age","name"]

class UserForm2(forms.Form):
    name=forms.CharField(min_length=2,max_length=20,widget=forms.TextInput(attrs={"class":"myfield"}))
    age=forms.IntegerField(min_value=1,max_value=100,widget=forms.NumberInput(attrs={"class":"myfield"}))
    email=forms.EmailField(required=False)
    weight=forms.DecimalField(min_value=3,max_value=200,decimal_places=2)
    required_css_class = "field"
    error_css_class = "error"