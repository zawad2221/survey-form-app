# survey-form-app

## add domain address 
Edit the domain address in saveResponse method in ResponseRepository.java file

public void saveResponse(Context context, Response response){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://www.yourdomainaddress.com/form/")
                .addConverterFactory(GsonConverterFactory.create());
        ...
        ...
        ....
        .....

    }