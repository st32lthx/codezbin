# author: Amin Meyghani
# May 29, 2013
#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#

admin_user  = AdminUser.new "tom", "johnson", 'tom@gmaillcom', "yes this is admin"
puts "information"
puts admin_user.first_name
puts admin_user.last_name
puts admin_user.email
puts admin_user.is_admin