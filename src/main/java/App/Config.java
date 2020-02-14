package App;

import com.google.inject.AbstractModule;

public class Config extends AbstractModule{
    @Override
    protected void configure() {
        bind(App_Interface.class).to(App.class);
    }
}
