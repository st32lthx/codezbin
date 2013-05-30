# author: Amin Meyghani
# May 29, 2013
# Simple demonstration of inheritance in Ruby
# The User class is the super class and the AdminClass is the subclass.
# The super method is used to avoid repeating the methods that are provided in the super class.
# The super method is used in the subclass and can be used inside any method definitions including the 
# initialize method.
#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#

admin_user  = AdminUser.new "tom", "johnson", 'tom@gmaillcom', "yes this is admin"
puts "information"
puts admin_user.first_name
puts admin_user.last_name
puts admin_user.email
puts admin_user.is_admin