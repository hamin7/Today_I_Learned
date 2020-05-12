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

    sudo useradd -m user01

    The useradd command's -m option also creates the user's home directory.

    There are many other options.

    -g group assignment

    -d directory

    -s shell

    -p Specify password (password)

    ![usr1](../Linux/images/usr1.png)

    ## Set password

    sudo passwd user01

    After creating a user, you must create a password.

    (You can change the user password expiration date using the chage command.)

    ## Check the created user (user)

    tail -n 3 / etc / passwd

    I used the tail command to check the contents at the bottom of the file.

    Created user information can be found in the / etc / passwd user file.

    User Name: Password: User ID: Group ID: Additional Information: Home Directory: Shell

    (For reference, group file is / etc / group, password file is / etc / shadow)

    ls / home /

    Confirm that the user's home directory has been created.

    Use the su command to change users on the console or terminal.

    ## Change User

    su user01

    Changing the user does not change the directory.

    Type exit to return to the previous user.

## 2. How to look the user into their home directory?

## Status comparison with or without home directory

If you log in while you have a home directory, you will see your account name (hamin) and current directory (~) on the command line as shown in the picture below.
'~' Means the home directory.
And if you look at files and folders with "ls -al" in your home directory, there are hidden files and folders that contain your account information.

![usr](./images/usr.png)

If you log in while your home directory is missing
1) An error message is displayed saying that the home directory cannot be found.
2) Connect to '/', the root home directory
3) The account name and current directory are not visible.

## Create a home directory manually

If you look at the error phrase, you can see where your home directory is set.

~~~markdown
Could not chdir to home directory /home/testUser:No such file or directory
~~~

First, create a directory that matches the address to create a home directory.
However, root authority may be required depending on the location, so use the root account or "sudo" appropriately.
After creating the directory, change the directory owner to "chown" so that testUser (ID) becomes the owner.

~~~markdown
$ sudo mkdir /home/testUser
$ sudo chown testUser.testUser /home/testUser
~~~

If you create a directory and log in again
1) The error phrase disappears
2) You will be connected to the directory you just created.

## Get basic account information

The home directory contains hidden files and directories for account information. However, since the newly created directory is empty, you cannot use the account normally even if you access the home directory.

The basic information (hidden files) that user accounts should have is contained in "/ etc / skel", and you can copy it and save it in the newly created directory.
The sub-contents of "/ etc" are information for the root account, so when copying, use the root account or "sudo" privilege.
It also changes the owner of the copied files after copying.

~~~ markdown
$ cd / home / testUser
$ sudo cp -r / etc / skel /. .
$ sudo chown -R testUser.testUser.
~~~

If you do the above, you can see that the home directory was created normally.

## 3. How to create SSH key?

## 4. Add SSH key to where?

## 5. How to enable SSH key access?