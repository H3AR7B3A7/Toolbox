import { Meta, moduleMetadata, Story } from '@storybook/angular';

import { MatButtonModule } from '@angular/material/button';

import { NavBarComponent } from './nav-bar.component';
import { HttpClientModule } from '@angular/common/http';
import { of } from 'rxjs';

export default {
    component: NavBarComponent,
    title: 'Home Page/NavBar',
    excludeStories: /.*Data$/,
    decorators: [
        moduleMetadata({
            imports: [MatButtonModule, HttpClientModule]
        })
    ]
} as Meta;

const Template: Story = (args) => ({
    props: {
        ...args
    }
});

export const Default = Template.bind({});
Default.args = {
    loggedIn: of(false)
};

Default.parameters = {
    docs: {
        description: {
            story: 'The logo, title and a login button are visible.'
        }
    }
};

export const LoggedIn = Template.bind({});
LoggedIn.args = {
    loggedIn: of(true),
    picture: of(
        'https://raw.githubusercontent.com/H3AR7B3A7/Toolbox/master/toolbox-fe/.storybook/public/profile-picture.png'
    )
};

LoggedIn.parameters = {
    docs: {
        description: {
            story: 'After logging in a logout button and a users profile picture are visible.'
        }
    }
};
