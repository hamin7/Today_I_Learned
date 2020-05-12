# Assignment 0.5

## 정보시스템학과 2017029134 이하민

## 1. How to add a user in Linux Command?

The useradd command adds a user account.
An account is a system that creates a user ID and password to grant a license.
The password generation command is passwd.

The Linux Unix operating system is a multi-user system.
When installing Linux, there is basically an administrator named super user, namely root,
This administrator has the authority to create and manage users who can access the system.

In other words, this command is used when the root authority creates a user other than root. It can be called useradd, but it can also be written as addUser.

~~~markdown
useradd [option] username(ID)
~~~

# Simple user add example

-useradd giancarlo: I added the account giancarlo without any options.
If only the user is created in this way, the user cannot connect because the password is not set.
This is because when you log in, you will be prompted to enter your password immediately.

-passwd giancarlo
Therefore, after creating an account, set the initial password for the account.

Now, to log in, just press alt + F2 to go to the virtual terminal tty2 and log in with the account you created.

When I log in, I get an alarm that the account has no home directory.
useradd doesn't just add a user account, it can be configured with several options.

## 2. How to look the user into their home directory?

## 3. How to create SSH key?

## 4. Add SSH key to where?

## 5. How to enable SSH key access?