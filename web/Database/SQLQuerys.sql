/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  santosh.babar
 * Created: Feb 4, 2019
 */

/*
Date: 29th Jan 2019
Changes to database to include status column in users table.
Query 1: Adding status column to users table 
Query 2: Update the status of all user to active*/ 
alter table users add column status varchar(20);
update users set status = "Active" where userid > 0;
